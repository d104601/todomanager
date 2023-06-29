package com.example.todomanager.service;

import com.example.todomanager.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos;

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}
