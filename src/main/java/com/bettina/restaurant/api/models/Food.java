package com.bettina.restaurant.api.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "foods")
@SQLDelete(sql = "UPDATE foods SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Food extends MenuItem {

    @NotNull(message = "Weight is required.")
    @Min(value = 0, message = "Weight must be a positive value.")
    private Integer weight;

    private boolean deleted = Boolean.FALSE;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
