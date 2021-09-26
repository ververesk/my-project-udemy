package org.spring.example.aop.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.spring.example.aop.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов перед методом getStudents");
//    }
//
//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) { //сюда прописываем то что возвращает getStudents
//      Student firstStudent=students.get(0);
//      String nameSurname=firstStudent.getNameSurname();
//      nameSurname="Ms "+nameSurname;
//      firstStudent.setNameSurname(nameSurname);
//      double avgGrade=firstStudent.getAvgGrade();
//      avgGrade=avgGrade+1;
//      firstStudent.setAvgGrade(avgGrade);
//
//
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка студентов после работы метода getStudents");
//    }

    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exeption") // в AfterThrowing нельзя обрабатывать исключения с помощью try
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exeption) { //в AfterThrowing можно увидеть исключение
        System.out.println("afterThrowingGetStudentsLoggingAdvice: логгируем выброс исключения "+exeption);
    }
}
