package com.todo.spring.mysql.repositories;


import com.todo.spring.mysql.models.Todo;
import com.todo.spring.mysql.repositories.base.TodoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SqlRepository implements TodoRepository {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void create(Todo todo) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(todo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Todo> getAll() {
        List<Todo> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from Todo").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Todo getById(int id) {
        Todo result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Todo.class, id);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Todo> getByStatus(boolean isActive) {
        List<Todo> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from Todo where isActive = :isActive")
                    .setParameter("isActive", isActive)
                    .list();
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public void update(int id, Todo todo) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Todo todoToChange = session.get(Todo.class, id);

            todoToChange.setTitle(todo.getTitle());
            todoToChange.setDescription(todo.getDescription());
            todoToChange.setActive(todo.getActive());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Todo todo = session.get(Todo.class, id);
            session.delete(todo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

