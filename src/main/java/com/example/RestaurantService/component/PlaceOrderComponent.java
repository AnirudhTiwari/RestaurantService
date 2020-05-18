package com.example.RestaurantService.component;

import com.example.RestaurantService.accessor.DeliveryServiceAccessor;
import com.example.RestaurantService.dao.ItemDao;
import com.example.RestaurantService.dao.OrderDao;
import com.example.RestaurantService.model.Item;
import com.example.RestaurantService.model.Order;
import com.example.RestaurantService.model.OrderItem;
import com.example.RestaurantService.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@AllArgsConstructor
public class PlaceOrderComponent {

    @Autowired
    private final ItemDao itemDAO;

    @Autowired
    private final OrderDao orderDAO;

    @Autowired
    private final DeliveryServiceAccessor deliveryServiceAccessor;

    /**
     * Creates an order by sending a request to the Delivery service to assign a delivery agent.
     *
     * @param @{itemsToQuantityMap}
     * @param orderItemsList
     * @param customerAddress
     * @return @{Order}
     */
    public Order placeOrder(@NonNull final List<OrderItem> orderItemsList, @NonNull final String customerAddress) {
        final Map<Item, Integer> translatedItemsToQuantityMap = translateItemsToQuantityMap(orderItemsList);

        final Order order = buildOrder(orderItemsList, translatedItemsToQuantityMap, customerAddress);

        final Order persistedOrder = orderDAO.persistOrderInDb(order);
        deliveryServiceAccessor.assignOrderToDeliveryService(persistedOrder.getId());

        return persistedOrder;
    }

    private Order buildOrder(final List<OrderItem> orderItemsList, final Map<Item, Integer> translatedItemsToQuantityMap
            , final String customerAddress) {
        return Order.builder()
                .orderItemList(orderItemsList)
                .orderPlacementTime(getCurrentTime())
                .orderStatus(OrderStatus.PREPARING)
                .customerAddress(customerAddress)
                .totalAmount(calculateTotalAmount(translatedItemsToQuantityMap))
                .build();
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

    private Map<Item, Integer> translateItemsToQuantityMap(final List<OrderItem> orderItemList) {
        final HashMap<Item, Integer> translatedItemsToQuantityMap = new HashMap<>();

        for (OrderItem orderItem : orderItemList) {
            final Item item = getItemFromDao(orderItem.itemId);
            translatedItemsToQuantityMap.put(item, orderItem.quantity);
        }

        return translatedItemsToQuantityMap;
    }

    private Item getItemFromDao(final String itemId) {
        final Optional<Item> item = itemDAO.getItem(itemId);
        if (item.isPresent()) {
            return item.get();
        } else {
            final String errorMsg = String.format("Item with ID: %s not found", itemId);
            throw new NoSuchElementException(errorMsg);
        }
    }
}
