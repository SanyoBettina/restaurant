package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.enums.MenuItemEnum;
import com.bettina.restaurant.api.models.Drink;
import com.bettina.restaurant.api.repositories.DrinkRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {
    private DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List <Drink> getAllSorted(){
        return drinkRepository.findAll((Sort.by(Sort.Direction.ASC, "name")));
    }

    public Drink save(Drink drink) {
        drink.setType(MenuItemEnum.DRINK);
        return drinkRepository.save(drink);
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
