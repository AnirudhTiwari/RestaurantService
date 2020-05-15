package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Item {
    @NonNull
    private final String id;

    @NonNull
    private final Double price;
}
