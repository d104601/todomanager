package com.example.todomanager.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
public class Todo {
    private int id;
    private String username;
    private String description;
    private String targetDate;
    private boolean done;
}
