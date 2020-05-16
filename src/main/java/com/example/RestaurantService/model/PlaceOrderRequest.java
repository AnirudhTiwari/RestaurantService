package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
@Builder
public class PlaceOrderRequest {

    @NonNull
    private final Map<String, Integer> itemIdToQuantityMap;

    @NonNull
    private final String address;
}
