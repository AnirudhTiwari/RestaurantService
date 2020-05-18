package com.example.RestaurantService.component;

import com.example.RestaurantService.dao.OrderDao;
import com.example.RestaurantService.model.Order;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
public class GetOrderStatusComponent {
    @Autowired
    private final OrderDao orderDAO;

    public String getOrderStatus(@NonNull final Long orderId) {
        Optional<Order> order = orderDAO.getOrder(orderId);
        if (order.isPresent()) {
            return order.get().getOrderStatus().name();
        } else {
            final String errorMsg = String.format("Item with ID: %s not found", orderId);
            throw new NoSuchElementException(errorMsg);
        }

    }
}
