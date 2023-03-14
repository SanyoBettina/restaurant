package com.bettina.restaurant.api.repositories;

import com.bettina.restaurant.api.models.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MenuItemBaseRepository<Food> {
}
