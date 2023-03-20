package com.bettina.restaurant.api.controllers;

import com.bettina.restaurant.api.models.Drink;
import com.bettina.restaurant.api.models.Food;
import com.bettina.restaurant.api.services.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        value = "/api/drinks",
        produces = "application/json"
)

public class DrinkController {
    private DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping("")
    public ResponseEntity<List<Drink>> list() {
        List<Drink> drinks = drinkService.getAllSorted();
        return new ResponseEntity<>(drinks, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid Drink drink) {
        Drink newDrink = drinkService.save(drink);
        return new ResponseEntity<>(newDrink, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid Drink drink) {
        Optional<Drink> currentDrink = drinkService.findById(id);

        if (!currentDrink.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        drinkService.update(currentDrink.get(), drink);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Optional<Drink> drink = drinkService.findById(id);
        if (!drink.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        drinkService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
