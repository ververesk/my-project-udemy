package org.spring.example.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class University {
    private List<Student>students=new ArrayList<>();

    public void addStudents() {
        Student st1=new Student("Veronika Hryharovich", 3, 8.6);
        Student st2=new Student("Masha Ivanova", 1, 7.6);
        Student st3=new Student("Igor Stepanov", 5, 9.6);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents() {
        System.out.println("Начало работы метода getStudents");
        System.out.println(students.get(4));
        System.out.println("Информация из метода getStudents: "+students);
        return students;
    }
}
