package com.todo.spring.mysql.service;

import com.todo.spring.mysql.models.Todo;
import com.todo.spring.mysql.repositories.base.TodoRepository;
import com.todo.spring.mysql.service.base.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository=todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return this.todoRepository.getAll();
    }

    @Override
    public Todo getTodoById(int id) {
        return this.todoRepository.getById(id);
    }

    @Override
    public List<Todo> getByStatus(boolean isActive) {
        return todoRepository.getByStatus(isActive);
    }

    @Override
    public void create(Todo todo) {
        todoRepository.create(todo);
    }

    @Override
    public void update(int id, Todo todo) {
        todoRepository.update(id, todo);
    }

    @Override
    public void delete(int id) {
        todoRepository.delete(id);
    }


}
