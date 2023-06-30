package com.example.todomanager.controller;

import com.example.todomanager.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {
    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todo-list")
    public String getAllTodos(ModelMap model) {
        model.put("todos", this.service.findByUsername("admin"));
        return "todo-list";
    }

    @GetMapping("/add-todo")
    public String addTodoPage() {
        return "add-todo";
    }

    @PostMapping("/add-todo")
    public String addTodo() {
        service.addTodo();
        return "redirect:/todo-list";
    }
}
