package com.bettina.restaurant.api.controllers;

import com.bettina.restaurant.api.models.OrderItem;
import com.bettina.restaurant.api.services.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(
        value = "/api/order_items",
        produces = "application/json")
public class OrderItemController {
    private OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid OrderItem orderItem) {
        orderItemService.save(orderItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
