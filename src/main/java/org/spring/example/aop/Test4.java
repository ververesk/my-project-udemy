package org.spring.example.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        System.out.println("метод main стартовал");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        NewUniLibrary newUniLibrary=context.getBean("newUniLibrary", NewUniLibrary.class);
        String bookName=newUniLibrary.returnBook();
        System.out.println("в библиотеку вернули книгу "+bookName);
        context.close();
        System.out.println("метод main закончил работу");
    }
}
