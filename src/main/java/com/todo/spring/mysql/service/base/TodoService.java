package com.todo.spring.mysql.service.base;

import com.todo.spring.mysql.models.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getAllTodos();

    Todo getTodoById(int id);

    List<Todo> getByStatus(boolean isActive);

    void create(Todo todo);

    void update (int id, Todo todo);

    void delete (int id);

}
