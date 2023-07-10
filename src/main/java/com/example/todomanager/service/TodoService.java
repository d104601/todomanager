package com.example.todomanager.service;

import com.example.todomanager.entity.Todo;
import com.example.todomanager.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> findByUsername(String username) {
        // stream api to filter todos by username
        return repository.findByUsername(username);
    }

    public void addTodo(String username, Todo todo) {
        todo.setUsername(username);
        repository.save(todo);
    }

    public Todo findById(int id) {
        Optional<Todo> todo = repository.findById(id);
        return todo.isPresent() ? todo.get() : null;
    }

    public void deleteTodoById(int id) {
        repository.deleteById(id);
    }

    public void updateTodo(Todo todo) {
        repository.save(todo);
    }
}
