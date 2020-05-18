package com.example.RestaurantService.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@Data
@Builder
@Table(name = "Items")
public class Item {

    @NonNull @Id
    private String id;

    @NonNull
    private Double price;

    protected Item() {}

}
