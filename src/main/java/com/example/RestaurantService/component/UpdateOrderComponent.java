package com.example.RestaurantService.component;

import com.example.RestaurantService.dao.OrderDao;
import com.example.RestaurantService.model.Order;
import com.example.RestaurantService.model.OrderStatus;
import com.example.RestaurantService.model.UpdateOrderRequest;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
public class UpdateOrderComponent {
    @NonNull
    private final OrderDao orderDao;

    public void updateOrder(@NonNull final UpdateOrderRequest updateOrderRequest) {
        final Long orderId = updateOrderRequest.getOrderId();
        final Optional<Order> order = orderDao.getOrder(orderId);

        if (!order.isPresent()) {
            final String errorMsg = String.format("Order with orderId %d not found ", orderId);
            throw new IllegalArgumentException(errorMsg);
        } else {
            final Order updatedOrder = updateOrderFrom(order.get(), updateOrderRequest);
            orderDao.persistOrderInDb(updatedOrder);
        }
    }

    private Order updateOrderFrom(Order staleOrder, UpdateOrderRequest updateOrderRequest) {
        final Long currentTime = new Date().getTime();
        final Order.OrderBuilder orderBuilder = Order.builder();

        final Order updatedOrder = orderBuilder
                .id(staleOrder.getId())
                .orderItemList(staleOrder.getOrderItemList())
                .orderPlacementTime(staleOrder.getOrderPlacementTime())
                .orderStatus(OrderStatus.valueOf(updateOrderRequest.getOrderStatus()))
                .customerAddress(staleOrder.getCustomerAddress())
                .totalAmount(staleOrder.getTotalAmount())
                .deliveryAgentId(updateOrderRequest.getDeliveryAgentId())
                .deliveryAgentName(updateOrderRequest.getDeliveryAgentName())
                .build();

        if (updateOrderRequest.getOrderStatus().equals(OrderStatus.IN_TRANSIT.toString())) {
            updatedOrder.setOrderPickupTime(currentTime);
        }

        else if (updateOrderRequest.getOrderStatus().equals(OrderStatus.DELIVERED.name())) {
            updatedOrder.setOrderCompletionTime(currentTime);
            updatedOrder.setOrderPickupTime(staleOrder.getOrderPickupTime());
        }

        return updatedOrder;
    }
}
