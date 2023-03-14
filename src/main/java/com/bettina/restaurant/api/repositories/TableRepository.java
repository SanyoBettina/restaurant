package com.bettina.restaurant.api.repositories;

import com.bettina.restaurant.api.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<RestaurantTable, Long> {
}
