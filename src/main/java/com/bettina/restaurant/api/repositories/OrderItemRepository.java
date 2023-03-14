package com.bettina.restaurant.api.repositories;

import com.bettina.restaurant.api.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> finByOrderId(Long id);
}
