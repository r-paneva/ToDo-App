package com.todo.spring.mysql;

import com.todo.spring.mysql.models.Todo;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Todo.class)
                .buildSessionFactory();
    }
}
