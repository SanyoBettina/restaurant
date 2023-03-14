package com.bettina.restaurant.api.models;

import com.bettina.restaurant.api.enums.MenuItemEnum;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MenuItemEnum type;

    public MenuItem() {
    }

    public MenuItem(MenuItemEnum type) {
        this.type = type;
    }
}
