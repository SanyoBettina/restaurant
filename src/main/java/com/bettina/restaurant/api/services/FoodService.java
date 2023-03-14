package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.enums.MenuItemEnum;
import com.bettina.restaurant.api.models.Food;
import com.bettina.restaurant.api.models.MenuItem;
import com.bettina.restaurant.api.repositories.FoodRepository;
import com.bettina.restaurant.api.repositories.MenuItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private FoodRepository foodRepository;
    private MenuItemRepository menuItemRepository;

    public FoodService(FoodRepository foodRepository, MenuItemRepository menuItemRepository) {
        this.foodRepository = foodRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Food> getAllSorted() {
        return foodRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public void save(Food food) {
        MenuItem menuItem = new MenuItem(MenuItemEnum.FOOD);
        menuItemRepository.save(menuItem);
        food.setMenuItem(menuItem);
        foodRepository.save(food);
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
