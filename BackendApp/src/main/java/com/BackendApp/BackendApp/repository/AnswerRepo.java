package com.BackendApp.BackendApp.repository;

import com.BackendApp.BackendApp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer, Integer> {
}
