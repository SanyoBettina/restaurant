package com.bettina.restaurant.api.controllers;

import com.bettina.restaurant.api.models.Order;
import com.bettina.restaurant.api.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        value = "/api/orders",
        produces = "application/json")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> list(@RequestParam(name="table_id", required = false) Long restaurantTableId) {
        List<Order> orders;
        if (restaurantTableId == null) {
            orders = orderService.getAll();
        } else {
            orders = orderService.getCurrentOrderByTable(restaurantTableId);
        }

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Order> create (@RequestBody @Valid Order order) {
        Order newOrder = orderService.save(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PatchMapping("{id}/paid")
    public ResponseEntity<?> updatePaidStatus (@PathVariable Long id) {
        Optional<Order> currentOrder = orderService.findById(id);

        if (!currentOrder.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Order order = currentOrder.get();
        order.setPaid(true);
        orderService.save(order);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
