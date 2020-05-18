package com.example.RestaurantService.controller;


import com.example.RestaurantService.activity.PlaceOrderActivity;
import com.example.RestaurantService.model.PlaceOrderRequest;
import com.example.RestaurantService.model.PlaceOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PlaceOrderController {

    @Autowired
    private final PlaceOrderActivity placeOrderActivity;

    @PostMapping("/placeOrder")
    public PlaceOrderResponse PlaceOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
        return placeOrderActivity.placeOrder(placeOrderRequest);
    }
}
