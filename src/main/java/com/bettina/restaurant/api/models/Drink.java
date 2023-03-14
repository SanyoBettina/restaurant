package com.bettina.restaurant.api.models;

import com.bettina.restaurant.api.enums.DrinkTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "drinks")
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Product name cannot be blank.")
    private String name;

    @NotNull(message = "Price is required.")
    @Min(value = 0, message = "Price must be higher than 0.")
    private Float price;

    @NotNull(message = "Drink type is required.")
    @Enumerated(EnumType.STRING)
    private DrinkTypeEnum drinkType;

    @NotNull(message = "Drink size is required.")
    @Min(value = 0, message = "Size must be higher than 0.")
    private Integer size;

    @OneToOne(cascade = CascadeType.ALL)
    private MenuItem menuItem;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public DrinkTypeEnum getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkTypeEnum drinkType) {
        this.drinkType = drinkType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
