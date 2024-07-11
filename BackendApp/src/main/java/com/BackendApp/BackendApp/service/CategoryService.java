package com.BackendApp.BackendApp.service;

import com.BackendApp.BackendApp.model.Answer;
import com.BackendApp.BackendApp.model.Category;
import com.BackendApp.BackendApp.model.Question;
import com.BackendApp.BackendApp.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    @Autowired
    private final CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Integer id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        log.info("Category with id: {} doesn't exist", id);
        return null;
    }

    public Category saveCategory(Category category) {
        Category savedCategory = categoryRepo.save(category);
        log.info("Category with id: {} saved successfully", category.getId());
        return savedCategory;
    }

//    @Transactional
//    public Category saveCategory(Category category) {
//        for (Question question : category.getQuestions()) {
//            question.setCategory(category);
//            for (Answer answer : question.getAnswers()) {
//                answer.setQuestion(question);
//            }
//        }
//        return categoryRepo.save(category);
//    }

    public Category updateCategory(Category category) {
        Optional<Category> existingCategory = categoryRepo.findById(category.getId());
        if (existingCategory.isPresent()) {
            Category updatedCategory = categoryRepo.save(category);
            log.info("Category with id: {} updated successfully", category.getId());
            return updatedCategory;
        }
        log.info("Category with id: {} doesn't exist", category.getId());
        return null;
    }

    public void deleteCategoryById(Integer id) {
        categoryRepo.deleteById(id);
    }
}
