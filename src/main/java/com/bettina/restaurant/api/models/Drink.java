package com.bettina.restaurant.api.models;

import com.bettina.restaurant.api.enums.DrinkTypeEnum;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "drinks")
@SQLDelete(sql = "UPDATE drinks SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Drink extends MenuItem {

    @NotNull(message = "Drink type is required.")
    @Enumerated(EnumType.STRING)
    private DrinkTypeEnum drinkType;

    @NotNull(message = "Drink size is required.")
    @Min(value = 0, message = "Size must be higher than 0.")
    private Double size;

    private boolean deleted = Boolean.FALSE;

    public DrinkTypeEnum getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkTypeEnum drinkType) {
        this.drinkType = drinkType;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
