package com.bettina.restaurant.api.enums;

public enum MenuItemEnum {
    FOOD("food"),
    DRINK("drink");

    private String menuItem;

    private MenuItemEnum(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getMenuItem() {
        return this.menuItem;
    }
}
