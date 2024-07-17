package com.BackendApp.BackendApp.repository;

import com.BackendApp.BackendApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
