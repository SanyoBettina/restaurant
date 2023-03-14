package com.bettina.restaurant.api.repositories;

import com.bettina.restaurant.api.models.Drink;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends MenuItemBaseRepository<Drink> {
}
