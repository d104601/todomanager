package com.example.todomanager.entity;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Todo {
    private int id;
    private String username;
    @Size(min = 5, message = "Enter at least 5 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
