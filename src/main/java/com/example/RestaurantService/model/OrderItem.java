package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {
    public String itemId;
    public Integer quantity;
}
