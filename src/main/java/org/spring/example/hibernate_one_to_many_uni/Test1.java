package org.spring.example.hibernate_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_one_to_many_uni.entity.Department;
import org.spring.example.hibernate_one_to_many_uni.entity.Employee;




public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session=null;


        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee employee=session.get(Employee.class,2);
//            System.out.println(employee);
            Department dep1=session.get(Department.class,1);
            Department dep2=session.get(Department.class,2);
            session.delete(dep1);
            session.delete(dep2);
//            session.beginTransaction();
//            Department department=session.get(Department.class,1);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//           session.getTransaction().commit(); //закрыли транзакцию
            //*************************************
//            Department dep=new Department("HR", 500,1500);
//            Employee emp1=new Employee("Oleg", "Ivamov",800);
//            Employee emp2=new Employee("Andrey", "Sidorov",1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.beginTransaction(); //открыли транзакцию
//            session.save(dep);
           session.getTransaction().commit(); //закрыли транзакцию
        }
        finally {
            factory.close();
            session.close();
        }
    }
}
