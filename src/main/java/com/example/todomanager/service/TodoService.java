package com.example.todomanager.service;

import com.example.todomanager.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 0;

    static {
        todos.add(new Todo(todoCount++, "admin", "Learn Spring MVC", "2020-01-01", false));
        todos.add(new Todo(todoCount++, "admin", "Learn Struts", "2020-01-01", false));
        todos.add(new Todo(todoCount++, "admin", "Learn Hibernate", "2020-01-01", false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description) {
        todos.add(new Todo(todoCount++, username, description, "2020-01-01", false));
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
