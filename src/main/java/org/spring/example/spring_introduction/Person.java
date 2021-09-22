package org.spring.example.spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personBean")
public class Person {
//    @Autowired
 //   @Qualifier("dog") //если подходящих бинов несколько то надо явно указать какой именно бин нам нужен
    private Pet pet;
    @Value("${person.surName}")
    private String surName;
    @Value("${person.age}")
    private int age;

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
  }
//     @Autowired
//    public Person(@Qualifier("catBean") Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//  }
//    public Person() {
//        System.out.println("Person bean is created");
//
//    }
    public void callYourPet() {
        System.out.println("Hello");
        pet.say();
    }
//называем в хмл pet потому что спринг должен сам переименовать в setPet. тое сть если мы назовем например home он превратится в setHome
 //   @Autowired
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public void setSurName(String surName) {
        System.out.println("Class Person: set surname");
        this.surName = surName;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }
}
