package com.example.RestaurantService.configuration;

import com.example.RestaurantService.controller.GetOrderStatusController;
import com.example.RestaurantService.controller.PlaceOrderController;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ControllerConfiguration {
    @NonNull
    private final ActivityConfiguration activityConfiguration;

    public PlaceOrderController getPlaceOrderController() {
        return new PlaceOrderController(activityConfiguration.getPlaceOrderActivity());
    }

    public GetOrderStatusController getGetOrderStatusController() {
        return new GetOrderStatusController(activityConfiguration.getGetOrderStatusActivity());
    }
}
