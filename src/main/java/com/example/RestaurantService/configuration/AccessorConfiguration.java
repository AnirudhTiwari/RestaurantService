package com.example.RestaurantService.configuration;

import com.example.RestaurantService.accessor.DeliveryServiceAccessor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AccessorConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public DeliveryServiceAccessor getDeliveryServiceAccessor() {
        return new DeliveryServiceAccessor();
    }
}
