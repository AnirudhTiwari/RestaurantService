package com.example.RestaurantService.dao;

import com.example.RestaurantService.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, String> {
    Optional<Item> findById(String itemId);
}
