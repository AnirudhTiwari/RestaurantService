package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Map;

@Data
@Builder
public class Order {
    @NonNull
    private final String Id;

    @NonNull
    private final Map<Item, Integer> itemsToQuantityMap;

    @NonNull
    private Double totalAmount;

    @NonNull
    private final OrderStatus orderStatus;

    @NonNull
    private final Long orderPlacementTime;

    @NonNull
    private final String customerAddress;

    private final User deliveryAgent;
    private final long orderCompletionTime;
    private final long orderPickupTime;
}
