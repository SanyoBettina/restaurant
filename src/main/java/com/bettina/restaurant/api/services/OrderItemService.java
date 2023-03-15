package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.dtos.OrderItemDTO;
import com.bettina.restaurant.api.models.MenuItem;
import com.bettina.restaurant.api.models.Order;
import com.bettina.restaurant.api.models.OrderItem;
import com.bettina.restaurant.api.repositories.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    private OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> getItems(Long id) {
        return orderItemRepository.findByOrderId(id);
    }

    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    public void save(OrderItemDTO orderItemDTO, Order order, MenuItem menuItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setMenuItem(menuItem);
        orderItem.setUnitPrice(menuItem.getPrice());
        orderItemRepository.save(orderItem);
    }

    public void update(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }
}
