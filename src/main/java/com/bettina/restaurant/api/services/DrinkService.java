package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.enums.MenuItemEnum;
import com.bettina.restaurant.api.models.Drink;
import com.bettina.restaurant.api.models.MenuItem;
import com.bettina.restaurant.api.repositories.DrinkRepository;
import com.bettina.restaurant.api.repositories.MenuItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {
    private DrinkRepository drinkRepository;
    private MenuItemRepository menuItemRepository;

    public DrinkService(DrinkRepository drinkRepository, MenuItemRepository menuItemRepository) {
        this.drinkRepository = drinkRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List <Drink> getAllSorted(){
        return drinkRepository.findAll((Sort.by(Sort.Direction.ASC, "name")));
    }

    public void save(Drink drink) {
        MenuItem menuItem = new MenuItem(MenuItemEnum.DRINK);
        menuItemRepository.save(menuItem);
        drink.setMenuItem(menuItem);
        drinkRepository.save(drink);
    }

    public Optional<Drink> findById(Long id) {
        return drinkRepository.findById(id);
    }

    public void update(Drink currentDrink, Drink newDrink) {
        currentDrink.setName(newDrink.getName());
        currentDrink.setPrice(newDrink.getPrice());
        currentDrink.setDrinkType(newDrink.getDrinkType());
        currentDrink.setSize(newDrink.getSize());

        drinkRepository.save(currentDrink);
    }
    public void delete(Long id) {
        drinkRepository.deleteById(id);
    }
}
