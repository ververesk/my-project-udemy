package org.spring.example.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_test.entity.Employee;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //открыли транзакцию
//            List<Employee> emps=session.createQuery("from Employee") //пишем не имя таблицы, а имя класса
//                    .getResultList();
            List<Employee> emps=session.createQuery("from Employee where name = 'Veronika'") //name это название поля класса
                   .getResultList();
            for (Employee e: emps) {
                System.out.println(e);
            }
            session.getTransaction().commit(); //закрыли транзакцию


        }
        finally {
            factory.close();
        }
    }
}
