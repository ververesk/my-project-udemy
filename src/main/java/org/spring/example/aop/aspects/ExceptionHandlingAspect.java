package org.spring.example.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("org.spring.example.aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeExceptionHandlingAspect() {
        System.out.println("beforeExceptionHandlingAspect: ловим/обрабатывает исключение при поытке получить книгу/журнал");
    }

    @Before("org.spring.example.aop.aspects.MyPointcutsForJoinPoint.allAddMethods()")
    public void beforeExceptionHandlingAspectForAdd() {
        System.out.println("beforeExceptionHandlingAspect: ловим/обрабатывает исключение при поытке получить книгу/журнал");
        System.out.println("----------------------------------------------");
    }
}
