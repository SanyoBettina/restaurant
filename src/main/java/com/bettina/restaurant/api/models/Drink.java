package com.bettina.restaurant.api.models;

import com.bettina.restaurant.api.enums.DrinkTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "drinks")
public class Drink extends MenuItem {

    @NotNull(message = "Drink type is required.")
    @Enumerated(EnumType.STRING)
    private DrinkTypeEnum drinkType;

    @NotNull(message = "Drink size is required.")
    @Min(value = 0, message = "Size must be higher than 0.")
    private Integer size;

    public DrinkTypeEnum getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkTypeEnum drinkType) {
        this.drinkType = drinkType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
