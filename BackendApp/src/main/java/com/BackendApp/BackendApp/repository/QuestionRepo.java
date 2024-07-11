package com.BackendApp.BackendApp.repository;

import com.BackendApp.BackendApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer>{

}
