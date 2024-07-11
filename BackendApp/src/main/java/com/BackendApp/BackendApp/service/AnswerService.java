package com.BackendApp.BackendApp.service;

import com.BackendApp.BackendApp.model.Answer;
import com.BackendApp.BackendApp.repository.AnswerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnswerService {

    private final AnswerRepo answerRepo;

    public List<Answer> getAllAnswers() {
        return answerRepo.findAll();
    }

    public Answer getAnswerById(Integer id) {
        Optional<Answer> optionalAnswer = answerRepo.findById(id);
        if (optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        }
        log.info("Answer with id: {} doesn't exist", id);
        return null;
    }

    public Answer saveAnswer(Answer answer) {
        Answer savedAnswer = answerRepo.save(answer);
        log.info("Answer with id: {} saved successfully", answer.getId());
        return savedAnswer;
    }

    public Answer updateAnswer(Answer answer) {
        Optional<Answer> existingAnswer = answerRepo.findById(answer.getId());
        if (existingAnswer.isPresent()) {
            Answer updatedAnswer = answerRepo.save(answer);
            log.info("Answer with id: {} updated successfully", answer.getId());
            return updatedAnswer;
        }
        log.info("Answer with id: {} doesn't exist", answer.getId());
        return null;
    }

    public void deleteAnswerById(Integer id) {
        answerRepo.deleteById(id);
    }
}
