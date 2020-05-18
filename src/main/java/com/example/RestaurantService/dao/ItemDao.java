package com.example.RestaurantService.dao;

import com.example.RestaurantService.model.Item;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemDao {

    @Autowired
    ItemRepository itemRepository;

    public Optional<Item> getItem(@NonNull final String id) {
        return itemRepository.findById(id);
    }
}
