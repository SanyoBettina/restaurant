package com.bettina.restaurant.api.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Name is required.")
    private String name;

    @NotNull(message = "Price is required.")
    @Min(value = 0, message = "Price must be higher than 0.")
    private Float price;

    @NotNull(message = "Weight is required.")
    @Min(value = 0, message = "Weight must be a positive value.")
    private Integer weight;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
