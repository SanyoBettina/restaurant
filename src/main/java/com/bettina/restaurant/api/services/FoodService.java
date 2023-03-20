package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.enums.MenuItemEnum;
import com.bettina.restaurant.api.models.Food;
import com.bettina.restaurant.api.repositories.FoodRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllSorted() {
        return foodRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Food save(Food food) {
        food.setType(MenuItemEnum.FOOD);
        return foodRepository.save(food);
    }

    public Optional<Food> findById(Long id) {
        return foodRepository.findById(id);
    }

    public void update(Food currentFood, Food newFood) {
        currentFood.setName(newFood.getName());
        currentFood.setPrice(newFood.getPrice());
        currentFood.setWeight(newFood.getWeight());

        foodRepository.save(currentFood);
    }

    public void delete(Long id) {
        foodRepository.deleteById(id);
    }

}
