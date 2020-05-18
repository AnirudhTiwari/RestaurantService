package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AssignOrderToDeliveryServiceRequest {
    @NonNull
    private final Long orderId;
}
