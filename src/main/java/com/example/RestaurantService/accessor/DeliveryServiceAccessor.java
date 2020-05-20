package com.example.RestaurantService.accessor;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DeliveryServiceAccessor {
    private static final String ASSIGN_ORDER_URI = "http://localhost:8081/assignOrder";

    @Autowired
    RestTemplate restTemplate;

    public void assignOrderToDeliveryService(@NonNull final Long orderId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ASSIGN_ORDER_URI)
                .queryParam("orderId", orderId);


        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                String.class
        );

    }
}
