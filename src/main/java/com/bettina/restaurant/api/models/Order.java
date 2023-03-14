package com.bettina.restaurant.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long restaurantTableId;

    @Column(nullable = false)
    private Date createdAt = new java.util.Date();

    private Boolean paid = false;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "order")
    private Set<OrderItem> orderItems;

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Long getRestaurantTableId() {
        return restaurantTableId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public void setRestaurantTableId(Long restaurantTableId) {
        this.restaurantTableId = restaurantTableId;
    }
}
