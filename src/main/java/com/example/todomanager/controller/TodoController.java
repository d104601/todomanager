package com.example.todomanager.controller;

import com.example.todomanager.entity.Todo;
import com.example.todomanager.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

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
    public String addTodoPage(ModelMap model) {
        Todo todo = new Todo(0, (String)model.get("username"), "", LocalDate.now(), false);
        model.put("todo", todo);
        return "add-todo";
    }

    @PostMapping("/add-todo")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "add-todo";
        }
        else {
            service.addTodo((String)model.get("username"), todo);
            return "redirect:/todo-list";
        }
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodoById(id);
        return "redirect:/todo-list";
    }

    @GetMapping("/update-todo")
    public String updateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = service.findById(id);
        model.put("todo", todo);
        return "update-todo";
    }

    @PostMapping("/update-todo")
    public String updateTodoById(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "update-todo";
        }
        else {
            todo.setUsername((String)model.get("username"));
            service.updateTodo(todo);
            return "redirect:/todo-list";
        }
    }
}
