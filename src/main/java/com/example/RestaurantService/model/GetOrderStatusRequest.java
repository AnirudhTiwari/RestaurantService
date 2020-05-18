package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class GetOrderStatusRequest {
    @NonNull
    private Long orderId;
}
