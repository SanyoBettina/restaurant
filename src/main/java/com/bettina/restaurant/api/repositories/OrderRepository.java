package com.bettina.restaurant.api.repositories;

import com.bettina.restaurant.api.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM orders where restaurant_table_id = ?1 AND paid = false", nativeQuery = true)
    List<Order> findByRestaurantTableId(Long id);
}
