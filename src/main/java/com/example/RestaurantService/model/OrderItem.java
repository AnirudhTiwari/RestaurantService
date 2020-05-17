package com.example.RestaurantService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
public class OrderItem {
    public String itemId;
    public Integer quantity;

    protected OrderItem() {}
}
