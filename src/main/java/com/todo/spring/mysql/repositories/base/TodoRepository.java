package com.todo.spring.mysql.repositories.base;

import com.todo.spring.mysql.models.Todo;

import java.util.List;

public interface TodoRepository {

    List<Todo> getAll();

    Todo getById(int id);

    List<Todo> getByStatus(boolean isActive);

    void update(int id, Todo todo);

    void delete(int id);

    void create(Todo todo);
}
