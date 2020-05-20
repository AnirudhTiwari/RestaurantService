package com.example.RestaurantService.component;

import com.example.RestaurantService.dao.OrderDao;
import com.example.RestaurantService.model.GetOrderStatusResponse;
import com.example.RestaurantService.model.Order;
import com.example.RestaurantService.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
public class GetOrderStatusComponent {
    @Autowired
    private final OrderDao orderDAO;

    //Hard coding ETA as 60 minutes once an order is placed
    private static final long ETA_POST_ORDER_PLACEMENT = 3600000;

    //Hard coding ETA as 30 minutes once an order is picked up
    private static  final long ETA_POST_ORDER_PICK_UP = 1800000;

    public GetOrderStatusResponse getOrderStatus(@NonNull final Long orderId) {
        Optional<Order> orderOptional = orderDAO.getOrder(orderId);
        if (orderOptional.isPresent()) {
            final Order order = orderOptional.get();
            final Long ETA = getOrderETA(order);
            return GetOrderStatusResponse.builder()
                    .orderId(orderId)
                    .orderStatus(order.getOrderStatus().name())
                    .ETA(ETA)
                    .build();
        } else {
            final String errorMsg = String.format("Item with ID: %s not found", orderId);
            throw new NoSuchElementException(errorMsg);
        }

    }

    private Long getOrderETA(final Order order) {
        final long currentTime = new Date().getTime();
        if (order.getOrderStatus().equals(OrderStatus.PREPARING)) {
            final long orderPlacementTime = order.getOrderPlacementTime();

            if (currentTime - orderPlacementTime < ETA_POST_ORDER_PLACEMENT) {
                return (ETA_POST_ORDER_PLACEMENT - (currentTime - orderPlacementTime)) / 60000;
            }
        }
        else if(order.getOrderStatus().equals(OrderStatus.IN_TRANSIT)) {
            final long orderPickupTime = order.getOrderPickupTime();

            if (currentTime - orderPickupTime < ETA_POST_ORDER_PICK_UP) {
                return (ETA_POST_ORDER_PICK_UP - (currentTime - orderPickupTime)) / 60000;
            }
        }
        return null;
    }
}
