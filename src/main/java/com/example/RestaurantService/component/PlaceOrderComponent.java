package com.example.RestaurantService.component;

import com.example.RestaurantService.dao.ItemDAO;
import com.example.RestaurantService.dao.OrderDAO;
import com.example.RestaurantService.model.Item;
import com.example.RestaurantService.model.Order;
import com.example.RestaurantService.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class PlaceOrderComponent {

    @Autowired
    private final ItemDAO itemDAO;

    @Autowired
    private final OrderDAO orderDAO;

    /**
     * Creates an order by sending a request to the Delivery service to assign a delivery agent.
     *
     * @param @{itemsToQuantityMap}
     * @return @{Order}
     */
    public Order placeOrder(@NonNull final Map<String, Integer> itemsToQuantityMap, @NonNull final String customerAddress) {
        final Map<Item, Integer> translatedItemsToQuantityMap = translateItemsToQuantityMap(itemsToQuantityMap);

        final Order order = Order.builder()
                .Id(UUID.randomUUID().toString())
                .itemsToQuantityMap(translatedItemsToQuantityMap)
                .orderPlacementTime(getCurrentTime())
                .orderStatus(OrderStatus.IN_PREPARATION)
                .customerAddress(customerAddress)
                .totalAmount(calculateTotalAmount(translatedItemsToQuantityMap))
                .build();

        orderDAO.persistOrderInDb(order);
        return order;
    }

    private Double calculateTotalAmount(Map<Item, Integer> translatedItemsToQuantityMap) {
        double amount = 0.0;

        for (Map.Entry<Item, Integer> entry : translatedItemsToQuantityMap.entrySet()) {
            final Double itemPrice = entry.getKey().getPrice();
            final Integer quantity = entry.getValue();
            amount += itemPrice * quantity;
        }
        return amount;
    }

    private Long getCurrentTime() {
        Date date = new Date();
        return date.getTime();
    }

    private Map<Item, Integer> translateItemsToQuantityMap(final Map<String, Integer> itemsToQuantityMap) {
        final HashMap<Item, Integer> translatedItemsToQuantityMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : itemsToQuantityMap.entrySet()) {
            final String itemId = entry.getKey();
            final Integer quantity = entry.getValue();
            final Item item = getItemFromDao(itemId);
            translatedItemsToQuantityMap.put(item, quantity);
        }

        return translatedItemsToQuantityMap;
    }

    private Item getItemFromDao(final String itemId) {
        return itemDAO.getItem(itemId);
    }
}
