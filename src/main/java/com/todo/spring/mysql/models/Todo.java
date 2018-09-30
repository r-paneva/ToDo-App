package com.todo.spring.mysql.models;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TodoID")
    private int todoId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;


    @Column(name = "Status")
    private boolean isActive;


    public Todo(String title, String description, Boolean isActive) {
        this.title = title;
        this.description = description;
        this.isActive = isActive;
    }

    public Todo() {
        this.isActive = true;
    }

    public boolean getActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

