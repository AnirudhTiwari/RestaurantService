package com.example.RestaurantService.controller;

import com.example.RestaurantService.activity.UpdateOrderActivity;
import com.example.RestaurantService.model.UpdateOrderRequest;
import com.example.RestaurantService.model.UpdateOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UpdateOrderController {
    @Autowired
    private final UpdateOrderActivity updateOrderActivity;

    @PutMapping("/updateOrder")
    public UpdateOrderResponse updateOrder(@RequestBody UpdateOrderRequest updateOrderRequest) {
        return updateOrderActivity.updateOrderStatus(updateOrderRequest);
    }
}
