package com.bettina.restaurant.api.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private MenuItem menuItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Order order;

    @NotNull(message = "Quantity is required.")
    @Min(value = 0, message = "Quantity must be a positive value.")
    private Integer Quantity;

    @Column(nullable = false)
    private Float unitPrice;

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
