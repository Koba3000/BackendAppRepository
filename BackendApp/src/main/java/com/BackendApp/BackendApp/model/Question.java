package com.BackendApp.BackendApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * An entity class represents a table in a relational database
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    @OneToMany(mappedBy = "question")
//    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Answer> answers;
}
