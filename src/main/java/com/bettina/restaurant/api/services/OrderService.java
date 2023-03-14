package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.models.Order;
import com.bettina.restaurant.api.models.RestaurantTable;
import com.bettina.restaurant.api.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
    public List<Order> getCurrentOrderByTable(Long restaurantId) {
        return orderRepository.findByRestaurantTableId(restaurantId);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

}
