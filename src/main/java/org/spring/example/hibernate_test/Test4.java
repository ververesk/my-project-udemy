package org.spring.example.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_test.entity.Employee;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //открыли транзакцию
            session.createQuery("update Employee set salary=1000 where name='Aleks'").executeUpdate();

//            Employee employee=session.get(Employee.class,1);
//            employee.setSalary(1000);

            session.getTransaction().commit(); //закрыли транзакцию


        }
        finally {
            factory.close();
        }
    }
}
