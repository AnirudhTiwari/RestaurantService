package com.example.RestaurantService.activity;

import com.example.RestaurantService.component.PlaceOrderComponent;
import com.example.RestaurantService.model.Order;
import com.example.RestaurantService.model.OrderItem;
import com.example.RestaurantService.model.PlaceOrderRequest;
import com.example.RestaurantService.model.PlaceOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
public class PlaceOrderActivity {
    @Autowired
    private final PlaceOrderComponent placeOrderComponent;

    public PlaceOrderResponse placeOrder(final PlaceOrderRequest placeOrderRequest) {
        final List<OrderItem> orderItemsList = placeOrderRequest.getItemsList();
        final String customerAddress = placeOrderRequest.getAddress();

        final Order order = placeOrderComponent.placeOrder(orderItemsList, customerAddress);
        return PlaceOrderResponse.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus().name())
                .build();
    }
}
