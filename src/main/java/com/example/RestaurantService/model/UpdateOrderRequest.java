package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UpdateOrderRequest {
    @NonNull
    private final Long orderId;

    @NonNull
    private final String orderStatus;

    private final Long deliveryAgentId;
    private final String deliveryAgentName;
}