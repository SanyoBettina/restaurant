package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.enums.MenuItemEnum;
import com.bettina.restaurant.api.models.Food;
import com.bettina.restaurant.api.models.MenuItem;
import com.bettina.restaurant.api.models.OrderItem;
import com.bettina.restaurant.api.repositories.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    private OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getItems(Long id) {
        return orderItemRepository.findByOrderId(id);
    }

    public void save(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
}
