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
        Todo todo = new Todo(0, (String)model.get("username"), "", "", false);
        model.put("todo", todo);
        return "add-todo";
    }

    @PostMapping("/add-todo")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "add-todo";
        }
        else {
            service.addTodo((String)model.get("username"), todo.getDescription());
            return "redirect:/todo-list";
        }
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodoById(id);
        return "redirect:/todo-list";
    }
}
