package com.BackendApp.BackendApp.controller;

import com.BackendApp.BackendApp.model.Question;
import com.BackendApp.BackendApp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@Validated
public class QuestionController {

    private final QuestionService questionService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Fetches all the questions in the question table
     * @return List of Questions
     */
    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return ResponseEntity.ok().body(questionService.getAllQuestions());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employee/v1/1 (or any other id)
     * Purpose: Fetches question with the given id
     * @param id - question id
     * @return Question with the given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(questionService.getQuestionById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Save a Question entity
     * @param question - Request body is a Question entity
     * @return Saved Question entity
     */
    @PostMapping("/")
    public ResponseEntity<Question> saveEmployee(@RequestBody Question question)
    {
        return ResponseEntity.ok().body(questionService.saveQuestion(question));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Update a Question entity
     * @param question - Question entity to be updated
     * @return Updated Question
     */
    @PutMapping("/")
    public ResponseEntity<Question> updateEmployee(@RequestBody Question question)
    {
        return ResponseEntity.ok().body(questionService.updateQuestion(question));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employee/v1/1 (or any other id)
     * Purpose: Delete a Question entity
     * @param id - question's id to be deleted
     * @return a String message indicating question record has been deleted successfully
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id)
    {
        questionService.deleteQuestionById(id);
        return ResponseEntity.ok().body("Deleted employee successfully");
    }


}