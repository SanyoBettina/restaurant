package com.bettina.restaurant.api.services;

import com.bettina.restaurant.api.models.MenuItem;
import com.bettina.restaurant.api.repositories.MenuItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MenuItemService {
    private MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public Optional<MenuItem> findById(Long id) {
        return menuItemRepository.findById(id);
    }

}
