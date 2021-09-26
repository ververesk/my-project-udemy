package org.spring.example.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* abc*())") //надо заменить на get поменяла чтобы работал тест 3
    public void allGetMethods() {}
}
