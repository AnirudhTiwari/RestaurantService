package com.example.RestaurantService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Builder
@Table(name = "CustomerOrders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    @NonNull
    private List<OrderItem> orderItemList;

    @NonNull
    private Double totalAmount;

    @NonNull
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @NonNull
    private Long orderPlacementTime;

    @NonNull
    private String customerAddress;

    private Long deliveryAgentId;

    private Long orderCompletionTime;

    public void setOrderCompletionTime(Long orderCompletionTime) {
        this.orderCompletionTime = this.orderCompletionTime == null ? orderCompletionTime : this.orderCompletionTime;
    }

    private Long orderPickupTime;

    public void setOrderPickupTime(Long orderPickupTime) {
        this.orderPickupTime = this.orderPickupTime == null ? orderPickupTime : this.orderPickupTime;
    }
    private String deliveryAgentName;

    protected Order() {}
}
