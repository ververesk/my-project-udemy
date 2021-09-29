package org.spring.example.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_test.entity.Employee;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Oleg", "Sidorov", "HR", 700);
            session.beginTransaction(); //открыли транзакцию
            session.save(employee); //сохранили
      //      session.getTransaction().commit(); //закрыли транзакцию

            int myId=employee.getId();
    //        session=factory.getCurrentSession();
  //          session.beginTransaction();
            Employee emp=session.get(Employee.class, myId);
            session.getTransaction().commit(); //транзакции всегда. даже если select
            System.out.println(emp);

        }
        finally {
            factory.close();
        }
    }
}
