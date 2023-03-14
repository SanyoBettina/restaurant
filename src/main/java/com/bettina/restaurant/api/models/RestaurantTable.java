package com.bettina.restaurant.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="restaurant_tables")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer nrOfSeats;

    public RestaurantTable() {}

    public RestaurantTable(Integer nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public Integer getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(Integer nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }
}
