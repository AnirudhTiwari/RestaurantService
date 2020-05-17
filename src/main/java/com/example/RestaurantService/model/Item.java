package com.example.RestaurantService.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Data
@Builder
public class Item {

    @NonNull @Id
    private String id;

    @NonNull
    private Double price;

    protected Item() {}

}
