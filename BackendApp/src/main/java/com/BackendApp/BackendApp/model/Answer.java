package com.BackendApp.BackendApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Boolean isCorrect;

//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    private Question question;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;
}
