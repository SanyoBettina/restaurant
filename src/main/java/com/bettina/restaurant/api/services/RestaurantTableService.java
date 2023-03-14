package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.models.RestaurantTable;
import com.bettina.restaurant.api.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantTableService {
    private TableRepository tableRepository;

    public RestaurantTableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<RestaurantTable> getAll() {
        return tableRepository.findAll();
    }

    public void saveAll(int nrOfTables, int nrOfSeats) {
       List<RestaurantTable> newTables = new ArrayList<>();
       for (int i=0; i<nrOfTables; i++) {
           newTables.add(new RestaurantTable(nrOfSeats));
       }

       tableRepository.saveAll(newTables);
    }

    public Optional<RestaurantTable> findById(Long id) {
       return tableRepository.findById(id);
    }

    public void delete(Long id) {
        tableRepository.deleteById(id);
    }
}
