package com.example.todomanager.service;

import com.example.todomanager.entity.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todoCount = 0;

    static {
        todos.add(new Todo(todoCount++, "admin", "Learn Spring MVC", LocalDate.now(), false));
        todos.add(new Todo(todoCount++, "admin", "Learn Struts", LocalDate.now(), false));
        todos.add(new Todo(todoCount++, "admin", "Learn Hibernate", LocalDate.now(), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, Todo todo) {
        todo.setId(todoCount++);
        todo.setUsername(username);
        todos.add(todo);
    }

    public Todo findById(int id) {
        for(Todo todo : todos) {
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void deleteTodoById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public void updateTodo(Todo todo) {
        todos.removeIf(t -> t.getId() == todo.getId());
        todos.add(todo);
    }
}
