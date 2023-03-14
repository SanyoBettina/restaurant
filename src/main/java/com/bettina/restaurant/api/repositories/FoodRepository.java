package com.bettina.restaurant.api.repositories;

import com.bettina.restaurant.api.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository <Food, Long>{
}
