package org.spring.example.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog myDog=context.getBean("myPet", Dog.class);
 //      myDog.setName("Belka");
        Dog yourDog=context.getBean("myPet", Dog.class);
 //      yourDog.setName("Strelka");
    System.out.println(myDog==yourDog);
  //      System.out.println(myDog.getName()); //имена будут стрелка, потому что это синглетон объект, то есть снчала собаку звали белка, потом переименовлась в стрелку
 //       System.out.println(yourDog.getName());// ели прототип то объекты будут разные, бин создается только когда мы его запрашиваем
        context.close();
    }
}
