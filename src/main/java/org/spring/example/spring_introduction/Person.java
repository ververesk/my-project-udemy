package org.spring.example.spring_introduction;

public class Person {
    private Pet pet;
    private String surName;
    private int age;


//    public Person(Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }
    public Person() {
        System.out.println("Person bean is created");

    }
    public void callYourPet() {
        System.out.println("Hello");
        pet.say();
    }
//называем в хмл pet потому что спринг должен сам переименовать в setPet. тое сть если мы назовем например home он превратится в setHome
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
