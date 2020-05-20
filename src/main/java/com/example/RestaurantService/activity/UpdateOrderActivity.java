package com.example.RestaurantService.activity;

import com.example.RestaurantService.component.UpdateOrderComponent;
import com.example.RestaurantService.model.UpdateOrderRequest;
import com.example.RestaurantService.model.UpdateOrderResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class UpdateOrderActivity {
    @NonNull
    private final UpdateOrderComponent updateOrderComponent;

    public UpdateOrderResponse updateOrderStatus(@NonNull final UpdateOrderRequest updateOrderRequest) {
        updateOrderComponent.updateOrder(updateOrderRequest);
        return UpdateOrderResponse.builder()
                .status("Success")
                .build();
    }
}
