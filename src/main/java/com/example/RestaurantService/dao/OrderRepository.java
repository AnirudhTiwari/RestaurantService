package com.example.RestaurantService.dao;

import com.example.RestaurantService.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
