package org.spring.example.hibernate_test2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_test2.entity.Detail;
import org.spring.example.hibernate_test2.entity.Employee;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session=null;
//        try {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Aleksandr", "Petrovenko", "IT", 610);
//            Detail detail=new Detail("Gomel", "6558", "weronnika@list.ru");
//            employee.setEmpDetail(detail);
//            session.beginTransaction(); //открыли транзакцию
//            session.save(employee);
//
//            session.getTransaction().commit(); //закрыли транзакцию
//
//        }
//        finally {
//            factory.close();
//        }
//
//
        try {
            session = factory.getCurrentSession();

            session.beginTransaction(); //открыли транзакцию
            Employee employee=session.get(Employee.class,2);
            session.delete(employee);
            session.getTransaction().commit(); //закрыли транзакцию

        }
        finally {
            factory.close();
            session.close();
        }
    }
}
