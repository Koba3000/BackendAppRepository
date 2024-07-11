package com.BackendApp.BackendApp.controller;

import com.BackendApp.BackendApp.model.Answer;
import com.BackendApp.BackendApp.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer/v3")
@RequiredArgsConstructor
@Validated
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        return ResponseEntity.ok().body(answerService.getAllAnswers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(answerService.getAnswerById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer) {
        return ResponseEntity.ok().body(answerService.saveAnswer(answer));
    }

    @PutMapping("/")
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer) {
        return ResponseEntity.ok().body(answerService.updateAnswer(answer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswerById(@PathVariable Integer id) {
        answerService.deleteAnswerById(id);
        return ResponseEntity.ok().body("Deleted answer successfully");
    }
}
