package com.example.RestaurantService.activity;

import com.example.RestaurantService.component.GetOrderStatusComponent;
import com.example.RestaurantService.model.GetOrderStatusRequest;
import com.example.RestaurantService.model.GetOrderStatusResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class GetOrderStatusActivity {
    @Autowired
    private final GetOrderStatusComponent getOrderStatusComponent;

    public GetOrderStatusResponse GetOrderStatus(@NonNull final GetOrderStatusRequest getOrderStatusRequest) {
        final Long orderID = getOrderStatusRequest.getOrderId();
        final String orderStatus = getOrderStatusComponent.getOrderStatus(orderID);
        return GetOrderStatusResponse.builder()
                .orderId(orderID)
                .orderStatus(orderStatus)
                .build();
    }
}
