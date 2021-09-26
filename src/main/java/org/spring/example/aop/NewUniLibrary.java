package org.spring.example.aop;

import org.springframework.stereotype.Component;
@Component
public class NewUniLibrary extends AbstractLibrary{


        public void getBook() {
            System.out.println("Мы берем книгу из NewUniLibrary ");
        }

        public String returnBook() {
            int a=10/0;
            System.out.println("Му возвращаем книгу в NewUniLibrary");
            return "Война и мир";
        }

        public void getMagazine () {
            System.out.println("Мы берем журнал из NewUniLibrary");
        }

    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в NewUniLibrary");
    }


    public void addBook() {
        System.out.println("Мы добавляем книгу в NewUniLibrary");
    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в NewUniLibrary");
    }
    }


