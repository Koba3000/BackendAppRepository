package com.BackendApp.BackendApp.repository;

import com.BackendApp.BackendApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
