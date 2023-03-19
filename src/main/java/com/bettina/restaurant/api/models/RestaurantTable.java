package com.bettina.restaurant.api.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="restaurant_tables")
@SQLDelete(sql = "UPDATE restaurant_tables SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer nrOfSeats;

    private boolean deleted = Boolean.FALSE;

    public RestaurantTable() {}

    public RestaurantTable(Integer nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public Long getId() {
        return id;
    }

    public Integer getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(Integer nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }
}
