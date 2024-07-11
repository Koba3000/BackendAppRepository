package com.BackendApp.BackendApp.service;

import com.BackendApp.BackendApp.model.Question;
import com.BackendApp.BackendApp.repository.QuestionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer is where all the business logic lies
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {

    private final QuestionRepo questionRepo;

    public List<Question> getAllQuestions(){
        return questionRepo.findAll();
    }

    public Question getQuestionById(Integer id){
        Optional<Question> optionalQuestion = questionRepo.findById(id);
        if(optionalQuestion.isPresent()){
            return optionalQuestion.get();
        }
        log.info("Question with id: {} doesn't exist", id);
        return null;
    }

    public Question saveQuestion (Question question){
        Question savedQuestion = questionRepo.save(question);

        log.info("Question with id: {} saved successfully", question.getId());
        return savedQuestion;
    }

    public Question updateQuestion (Question question) {
        Optional<Question> existingQuestion = questionRepo.findById(question.getId());

        Question updatedQuestion = questionRepo.save(question);

        log.info("Question with id: {} updated successfully", question.getId());
        return updatedQuestion;
    }

    public void deleteQuestionById (Integer id) {
        questionRepo.deleteById(id);
    }

}