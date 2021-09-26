package org.spring.example.aop;

import org.spring.example.aop.aspects.UniLibraryForJointPoint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
   //     NewUniLibrary newUniLibrary=context.getBean("newUniLibrary", NewUniLibrary.class);
        UniLibraryForJointPoint uniLibraryForJointPoint=context.getBean("uniLibraryForJointPoint", UniLibraryForJointPoint.class);
        Book book=context.getBean("book", Book.class);
        uniLibraryForJointPoint.getBook();
        uniLibraryForJointPoint.addBook("Вероника", book);
        uniLibraryForJointPoint.addMagazine();
  //      newUniLibrary.returnMagazine();
   //     newUniLibrary.addBook();
        context.close();
    }

}
