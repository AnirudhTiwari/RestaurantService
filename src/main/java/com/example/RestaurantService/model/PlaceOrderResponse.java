package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class PlaceOrderResponse {
    @NonNull
    private final String orderId;

    @NonNull
    private final String orderStatus;
}
