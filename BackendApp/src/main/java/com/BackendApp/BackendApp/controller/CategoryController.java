package com.BackendApp.BackendApp.controller;

import com.BackendApp.BackendApp.model.Category;
import com.BackendApp.BackendApp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/v1")
@RequiredArgsConstructor
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            List<Category> categories = categoryService.getAllCategories();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

//    @PostMapping
//    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
//        Category savedCategory = categoryService.saveCategory(category);
//        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
//    }

    @PostMapping("/")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return ResponseEntity.ok().body(categoryService.saveCategory(category));
    }

    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        return ResponseEntity.ok().body(categoryService.updateCategory(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().body("Deleted category successfully");
    }
}
