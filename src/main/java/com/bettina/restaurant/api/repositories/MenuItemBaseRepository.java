package com.bettina.restaurant.api.repositories;

import com.bettina.restaurant.api.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MenuItemBaseRepository<T extends MenuItem> extends JpaRepository<T, Long> {
}
