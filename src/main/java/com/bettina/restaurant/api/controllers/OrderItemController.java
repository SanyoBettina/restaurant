package com.bettina.restaurant.api.controllers;

import com.bettina.restaurant.api.dtos.OrderItemDTO;
import com.bettina.restaurant.api.models.MenuItem;
import com.bettina.restaurant.api.models.Order;
import com.bettina.restaurant.api.models.OrderItem;
import com.bettina.restaurant.api.services.MenuItemService;
import com.bettina.restaurant.api.services.OrderItemService;
import com.bettina.restaurant.api.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping(
        value = "/api",
        produces = "application/json")
public class OrderItemController {
    private OrderItemService orderItemService;
    private OrderService orderService;
    private MenuItemService menuItemService;

    public OrderItemController(OrderItemService orderItemService, OrderService orderService, MenuItemService menuItemService) {
        this.orderItemService = orderItemService;
        this.orderService = orderService;
        this.menuItemService = menuItemService;
    }

    @PostMapping("orders/{orderId}/order_items")
    public ResponseEntity<?> create(@PathVariable Long orderId, @RequestBody @Valid OrderItemDTO orderItemDTO) {
        Optional<Order> currentOrder = orderService.findById(orderId);
        if (!currentOrder.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Optional<MenuItem> menuItem = menuItemService.findById(orderItemDTO.getMenuItemId());
        if (!menuItem.isPresent()) {
            throw new RuntimeException("Invalid menu item.");
        }

        orderItemService.save(orderItemDTO, currentOrder.get(), menuItem.get());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("order_items/{id}/{quantity}")
    public ResponseEntity<?> updateQuantity (@PathVariable Long id, @PathVariable Integer quantity) {
        Optional<OrderItem> currentOrderItem = orderItemService.findById(id);

        if (!currentOrderItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        OrderItem orderItem = currentOrderItem.get();
        orderItem.setQuantity(quantity);
        orderItemService.update(orderItem);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("order_items/{id}")
    public ResponseEntity<?> delete (@PathVariable("id")Long id) {
        Optional<OrderItem> food = orderItemService.findById(id);
        if (!food.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        orderItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
