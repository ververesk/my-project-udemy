package org.spring.example.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{

    public void getBook(Book book) {
        System.out.println("Мы берем книгу из UniLibrary "+book.getName());
    }

    public String returnBook() {
        System.out.println("Му возвращаем книгу в UniLibrary");
        return "OK";
    }

    public void getMagazine (int a) {
        System.out.println("Мы берем журнал из UniLibrary");
    }

}


