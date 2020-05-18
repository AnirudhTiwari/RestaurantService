package com.example.RestaurantService.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetOrderStatusResponse {
    private final Long orderId;
    private final String orderStatus;
}
