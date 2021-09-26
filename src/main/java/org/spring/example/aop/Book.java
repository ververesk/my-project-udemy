package org.spring.example.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Преступление и наказание")
    private String name;
    @Value("Ф. М. Достоевский")
    private String Author;
    @Value("1986")
    private int yearOfPublication;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return Author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
