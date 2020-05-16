package com.example.RestaurantService.dao;

import com.example.RestaurantService.model.Item;
import lombok.NonNull;

public class ItemDAO {
    public Item getItem(@NonNull final String id) {
        //Insert code to access the db to access the item from the item table.
        return Item.builder().id(id).build();
    }
}
