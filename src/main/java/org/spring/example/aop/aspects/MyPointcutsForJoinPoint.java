package org.spring.example.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcutsForJoinPoint {
    @Pointcut("execution(* abc*(..))") //abc надо исправить на add
    public void allAddMethods() {}
}
