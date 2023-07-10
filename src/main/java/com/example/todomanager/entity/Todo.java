package com.example.todomanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "todos")
public class Todo {
    @Id
    @GeneratedValue
    private int id;

    private String username;
    @Size(min = 5, message = "Enter at least 5 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
