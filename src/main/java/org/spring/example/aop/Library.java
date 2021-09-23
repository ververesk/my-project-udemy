package org.spring.example.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {
    public void getBook() {
        System.out.println("Мы берем книгу");
    }
}
