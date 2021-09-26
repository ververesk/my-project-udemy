package org.spring.example.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.spring.example.aop.Book;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class NewLoggingAndSecurityAspect {

    //создаем пойнткат который подходит для всех методов из newunilibrary кроме returnMagazine
//    @Pointcut("execution(* org.spring.example.aop.NewUniLibrary.*(..))") //любой метод с любым колич параметров
//    private void allMethodsFromNewUniLibrary() {}
//
//    @Pointcut("execution(public void org.spring.example.aop.NewUniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary() {}
//
//    @Pointcut("allMethodsFromNewUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromNewUniLibrary() {}
//
//    @Before("allMethodsExceptReturnMagazineFromNewUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineFromNewUniLibrary() {
//        System.out.println("beforeAllMethodsExceptReturnMagazineFromNewUniLibrary: writing Log#10");
//    }

//    @Pointcut("execution(* get*())")
//    private void allGetMethodsFromNewUniLibrary() {}
//
//    @Pointcut("execution(* return*())")
//    private void allReturnMethodsFromNewUniLibrary() {}
//
//    @Pointcut("allGetMethodsFromNewUniLibrary() || allReturnMethodsFromNewUniLibrary()")
//    private void allGetANdReturnMethodsFromNewUniLibrary() {}
//
//    @Before("allGetMethodsFromNewUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log#1");
//    }
//
//    @Before("allReturnMethodsFromNewUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log#2");
//    }
//    @Before("allGetANdReturnMethodsFromNewUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log#3");
//    }

 //   @Pointcut("execution(* get*())")
 //   private void allGetMethods() {}
    @Before("org.spring.example.aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу или журнал");
    }

    @Before("org.spring.example.aop.aspects.MyPointcutsForJoinPoint.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature= (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature= "+methodSignature);
        System.out.println("methodSignature.getMethod()= "+methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType()= "+methodSignature.getReturnType());
        System.out.println("methodSignature.getName()= "+methodSignature.getName());
        if(methodSignature.getName().equals("addBook")) {
            Object [] arguments=joinPoint.getArgs();
            for (Object obj : arguments) {
                if(obj instanceof Book) {
                    Book myBook=(Book) obj;
                    System.out.println("ИНформация о книге: название - "+
                            myBook.getName()+", автор - "+myBook.getAuthor()+
                            ", год выпуска - "+myBook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("книгу в библиотку добавляет "+obj);
                }
            }
        }

        System.out.println("beforeAddLoggingAdvice: логирование попытки получить книгу или журнал");
        System.out.println("----------------------------------------------");
    }
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги или журнала");
//    }
}
