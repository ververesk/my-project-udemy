package org.spring.example.aop.aspects;

import org.spring.example.aop.AbstractLibrary;
import org.spring.example.aop.Book;
import org.springframework.stereotype.Component;

@Component
public class UniLibraryForJointPoint extends AbstractLibrary {
    public void getBook() {
        System.out.println("Мы берем книгу из NewUniLibrary ");
        System.out.println("----------------------------------------------");
    }

    public void returnBook() {
        System.out.println("Му возвращаем книгу в NewUniLibrary");
        System.out.println("----------------------------------------------");
    }

    public void getMagazine () {
        System.out.println("Мы берем журнал из NewUniLibrary");
        System.out.println("----------------------------------------------");
    }

    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в NewUniLibrary");
        System.out.println("----------------------------------------------");
    }


    public void addBook(String PersonName, Book book) {
        System.out.println("Мы добавляем книгу в NewUniLibrary");
        System.out.println("----------------------------------------------");
    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в NewUniLibrary");
        System.out.println("----------------------------------------------");
    }
}

