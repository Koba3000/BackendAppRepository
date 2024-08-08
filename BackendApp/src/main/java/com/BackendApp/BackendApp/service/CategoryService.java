package com.BackendApp.BackendApp.service;

import com.BackendApp.BackendApp.model.Answer;
import com.BackendApp.BackendApp.model.Category;
import com.BackendApp.BackendApp.model.Question;
import com.BackendApp.BackendApp.repository.CategoryRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    @Transactional
    public Category saveCategory(Category category) {
        if (categoryRepo.findByName(category.getName()).isPresent()) {
            // Throw an exception or handle it as you see fit
            throw new IllegalStateException("Category with name " + category.getName() + " already exists.");
        }
        // Ensure bidirectional relationships are set
        if (category.getQuestions() != null) {
            for (Question question : category.getQuestions()) {
                question.setCategory(category); // Set the category for each question
                if (question.getAnswers() != null) {
                    for (Answer answer : question.getAnswers()) {
                        answer.setQuestion(question); // Set the question for each answer
                    }
                }
            }
        }
        return categoryRepo.save(category);
    }


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
