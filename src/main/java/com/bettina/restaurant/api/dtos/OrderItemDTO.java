package com.bettina.restaurant.api.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderItemDTO {
    @NotNull(message = "Menu item is required.")
    private Long menuItemId;
    @NotNull(message = "Quantity is required.")
    @Min(value = 0, message = "Quantity must be a positive value.")
    private Integer quantity;

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
