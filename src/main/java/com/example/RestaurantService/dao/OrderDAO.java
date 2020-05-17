package com.example.RestaurantService.dao;

import com.example.RestaurantService.model.Order;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDAO {

    @Autowired
    OrderRepository orderRepository;

    public Order persistOrderInDb(@NonNull final Order order) {
        return orderRepository.save(order);
    }
}
