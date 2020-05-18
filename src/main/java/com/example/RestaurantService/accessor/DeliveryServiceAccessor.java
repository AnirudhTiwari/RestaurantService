package com.example.RestaurantService.accessor;


import com.example.RestaurantService.model.AssignOrderToDeliveryServiceResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DeliveryServiceAccessor {
    private static final String ASSIGN_ORDER_URL = "http://localhost:8081/assignOrder";

    @Autowired
    RestTemplate restTemplate;

    public void assignOrderToDeliveryService(@NonNull final Long orderId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ASSIGN_ORDER_URL)
                .queryParam("orderId", orderId);


        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        HttpEntity<AssignOrderToDeliveryServiceResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.POST,
                entity,
                AssignOrderToDeliveryServiceResponse.class
        );

    }
}
