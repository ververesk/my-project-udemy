package org.spring.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

 //   @Before("execution(public void org.spring.example.aop.UniLibrary.getBook())") что работал определенный метод из определннного класса
 //   @Before("execution(public void get*())") //срабатыввают все методы которые начинаются с гет
 //    @Before("execution(public void getBook(String))")
// @Before("execution(public void get*(*))") //* подходят люьые параметры
    @Before("execution(public void getBook(org.spring.example.aop.Book))") //* подходят люьые параметры
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

    @Before("execution(* returnBook())") //нет access modifier то есть все равно public или что-то ещё
    //* означает на зависит от типа возвращаемого результата
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: попытка получить книгу");
    }



}

