package org.spring.example.hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_one_to_one.entity.Detail;
import org.spring.example.hibernate_one_to_one.entity.Employee;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session=null;
        try {
//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
//            Detail detail=new Detail("New-York", "6558666", "nilolay@list.ru");
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//
//            session.beginTransaction(); //открыли транзакцию
//            session.save(detail);
//
//            session.getTransaction().commit(); //закрыли транзакцию
//            session = factory.getCurrentSession();
//
//
//          session.beginTransaction(); //открыли транзакцию
//           Detail detail=session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//
//            session.getTransaction().commit(); //закрыли транзакцию
            session = factory.getCurrentSession();


         session.beginTransaction(); //открыли транзакцию
           Detail detail=session.get(Detail.class, 4);
           session.delete(detail);

            session.getTransaction().commit(); //закрыли транзакцию
        }
        finally {
            factory.close();
            session.close();

        }
    }
}
