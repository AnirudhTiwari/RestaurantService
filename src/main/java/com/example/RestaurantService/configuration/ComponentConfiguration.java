package com.example.RestaurantService.configuration;

import com.example.RestaurantService.component.PlaceOrderComponent;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ComponentConfiguration {
    @Autowired
    public final DAOConfiguration daoConfiguration;

    @Bean
    public PlaceOrderComponent getPlaceOrderComponent() {
        return new PlaceOrderComponent(daoConfiguration.getItemDAO(), daoConfiguration.getOrderDAO());
    }

}
