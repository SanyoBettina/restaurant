package com.bettina.restaurant.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DrinkTypeEnum {
    BOTTLE("bottle"),
    DOSE("dose"),
    CUP("cup");

    private String drinkType;

    DrinkTypeEnum(String drinkType) {
        this.drinkType = drinkType;
    }

    @JsonValue
    public String getDrinkType() {
        return drinkType;
    }
}
