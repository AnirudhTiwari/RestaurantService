package com.example.RestaurantService.configuration;

import com.example.RestaurantService.activity.GetOrderStatusActivity;
import com.example.RestaurantService.activity.PlaceOrderActivity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ActivityConfiguration {
    @Autowired
    private final ComponentConfiguration componentConfiguration;

    @Bean
    public PlaceOrderActivity getPlaceOrderActivity() {
        return new PlaceOrderActivity(componentConfiguration.getPlaceOrderComponent());
    }

    @Bean
    public GetOrderStatusActivity getGetOrderStatusActivity() {
        return new GetOrderStatusActivity(componentConfiguration.getGetOrderStatusComponent());
    }
}
