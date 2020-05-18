package com.example.RestaurantService.controller;

import com.example.RestaurantService.activity.GetOrderStatusActivity;
import com.example.RestaurantService.model.GetOrderStatusRequest;
import com.example.RestaurantService.model.GetOrderStatusResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetOrderStatusController {
    @Autowired
    private final GetOrderStatusActivity getOrderStatusActivity;

    @GetMapping("/getOrderStatus")
    public GetOrderStatusResponse getOrderStatus(@RequestParam(value = "orderId") Long orderId) {
        final GetOrderStatusRequest getOrderStatusRequest = GetOrderStatusRequest.builder().orderId(orderId).build();
        return getOrderStatusActivity.GetOrderStatus(getOrderStatusRequest);
    }
}
