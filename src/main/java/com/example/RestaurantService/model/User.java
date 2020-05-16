package com.example.RestaurantService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class User {
    private final String userId;
}
