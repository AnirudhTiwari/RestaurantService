package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class DeliveryAgent {
    @NonNull
    private final String id;

    @NonNull
    private final DeliveryAgentStatus deliveryAgentStatus;

    private final String assignedOrderId;
}
