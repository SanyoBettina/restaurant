package com.bettina.restaurant.api.controllers;

import com.bettina.restaurant.api.models.Food;
import com.bettina.restaurant.api.services.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        value = "/api/foods",
        produces = "application/json"
)
public class FoodController {
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("")
    public ResponseEntity <List<Food>> list(){
        List<Food> foods = foodService.getAllSorted();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create (@RequestBody @Valid Food food) {
        Food createdFood = foodService.save(food);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable("id") Long id, @RequestBody @Valid Food food) {
        Optional<Food> currentFood = foodService.findById(id);

        if (!currentFood.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        foodService.update(currentFood.get(), food);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id")Long id) {
        Optional<Food> food = foodService.findById(id);
        if (!food.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
