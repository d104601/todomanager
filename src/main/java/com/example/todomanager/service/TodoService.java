package com.example.todomanager.service;

import com.example.todomanager.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos;


    public List<Todo> findByUsername(String username) {
        todos = new ArrayList<>();
        todos.add(new Todo(1, "admin", "Learn Spring MVC", "2020-01-01", false));
        todos.add(new Todo(2, "admin", "Learn Struts", "2020-01-01", false));
        todos.add(new Todo(3, "admin", "Learn Hibernate", "2020-01-01", false));

        return todos;
    }

    public void addTodo() {

    }
}
