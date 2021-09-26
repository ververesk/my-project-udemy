package org.spring.example.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspectForAroundAdvice {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAspectForAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("aroundReturnBookLoggingAspectForAroundAdvice: в библиотеку пытаются вернуть книгу");
   //     long begin=System.currentTimeMillis();
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
            targetMethodResult="Преступление и наказание";
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAspectForAroundAdvice было полймано исключение "+e);
         //   targetMethodResult="Неизвестное название книги";
            throw e; //выбрасываем исключение дальше
        }

    //    long end=System.currentTimeMillis();
        System.out.println("aroundReturnBookLoggingAspectForAroundAdvice: в библиотеку успешко вернули книгу");
   //     System.out.println("aroundReturnBookLoggingAspectForAroundAdvice: метод returnBook выполнил работу за "+(end-begin));
        return targetMethodResult;
    }
}
