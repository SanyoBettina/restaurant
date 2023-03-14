package com.bettina.restaurant.api.repositories;

import com.bettina.restaurant.api.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long>{
}
