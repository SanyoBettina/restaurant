package com.bettina.restaurant.api.models;

import com.bettina.restaurant.api.enums.MenuItemEnum;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "menu_items")
@SQLDelete(sql = "UPDATE menu_items SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public abstract class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MenuItemEnum type;

    @Column(nullable = false)
    @NotBlank(message = "Name is required.")
    private String name;

    @NotNull(message = "Price is required.")
    @Min(value = 0, message = "Price must be higher than 0.")
    private Float price;

    private boolean deleted = Boolean.FALSE;

    public MenuItem() {
    }

    public Long getId() {
        return id;
    }

    public MenuItemEnum getType() {
        return type;
    }

    public void setType(MenuItemEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
