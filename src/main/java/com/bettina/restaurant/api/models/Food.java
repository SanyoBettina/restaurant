package com.bettina.restaurant.api.models;

import com.bettina.restaurant.api.enums.MenuItemEnum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "foods")
public class Food extends MenuItem {

    @NotNull(message = "Weight is required.")
    @Min(value = 0, message = "Weight must be a positive value.")
    private Integer weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
