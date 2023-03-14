package com.bettina.restaurant.api.controllers;

import com.bettina.restaurant.api.models.RestaurantTable;
import com.bettina.restaurant.api.services.RestaurantTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(
        value = "/api/tables",
        produces = "application/json"
)
public class RestaurantTableController {
    private RestaurantTableService tableService;

    public RestaurantTableController(RestaurantTableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("")
    public ResponseEntity<List<RestaurantTable>> list() {
        List<RestaurantTable> tables = tableService.getAll();

        return new ResponseEntity<>(tables, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Map<String, String> json) {
        int nrOfTables = Integer.parseInt(json.get("nr_of_tables"));
        int nrOfSeats = Integer.parseInt(json.get("nr_of_seats"));
        tableService.saveAll(nrOfTables, nrOfSeats);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        Optional<RestaurantTable>restaurantTable = tableService.findById(id);
        if (!restaurantTable.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        tableService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
