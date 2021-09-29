package org.spring.example.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_test.entity.Employee;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //открыли транзакцию

//           Employee employee=session.get(Employee.class,2);
//           session.delete(employee);
            session.createQuery("delete Employee where name='Aleks'").executeUpdate();
            session.getTransaction().commit(); //закрыли транзакцию


        }
        finally {
            factory.close();
        }
    }
}
