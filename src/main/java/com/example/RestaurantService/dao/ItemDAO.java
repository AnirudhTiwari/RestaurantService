package com.example.RestaurantService.dao;

import com.example.RestaurantService.model.Item;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ItemDAO {

    @Autowired
    ItemRepository itemRepository;

    public Item getItem(@NonNull final String id) {
        Optional<Item> item = itemRepository.findById(id);

        if (item.isPresent()) {
            return item.get();
        } else {
            final String errorMsg = String.format("Item with ID: %s not found", id);
            throw new NoSuchElementException(errorMsg);
        }
    }
}
