package com.example.RestaurantService.dao;

import com.example.RestaurantService.model.Order;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderDao {

    @Autowired
    OrderRepository orderRepository;

    public Order persistOrderInDb(@NonNull final Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getOrder(@NonNull final Long orderId) {
        return orderRepository.findById(orderId);
    }
}
