package com.example.RestaurantService.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder

public class UpdateOrderResponse {
    @NonNull
    private String status;
}
