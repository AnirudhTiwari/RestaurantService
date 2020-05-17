package com.example.RestaurantService.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderRequest {

    @NonNull
    private List<OrderItem> itemsList;

    @NonNull
    private String address;
}
