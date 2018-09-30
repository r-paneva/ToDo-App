package com.todo.spring.mysql.controllers;

import com.todo.spring.mysql.models.Todo;
import com.todo.spring.mysql.service.base.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoRestController {
    private TodoService service;

    @Autowired
    public TodoRestController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public void create(@RequestBody Todo todo) {
        service.create(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return service.getTodoById(id);
    }

    @GetMapping("/status/{status}")
    List<Todo> getByStatus(@PathVariable boolean status) {
        return service.getByStatus(status);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Todo todo) {
        service.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
