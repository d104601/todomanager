package com.example.todomanager.controller;

import com.example.todomanager.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class TodoController {
    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    public String getAllTodos(ModelMap model) {
        model.put("todos", this.service.findByUsername("admin"));
        return "todo-list";
    }
}
