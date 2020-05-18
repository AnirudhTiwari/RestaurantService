package com.example.RestaurantService.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class AssignOrderToDeliveryServiceResponse {
    private final Long deliveryAgentId;
    private final String status;
}
