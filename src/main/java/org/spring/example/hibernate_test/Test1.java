package org.spring.example.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_test.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Aleksandr", "Petrovenko", "IT", 610);
            session.beginTransaction(); //открыли транзакцию
            session.save(employee); //сохранили
            session.getTransaction().commit(); //закрыли транзакцию
            System.out.println(employee);
        }
        finally {
            factory.close();
        }
    }
}
