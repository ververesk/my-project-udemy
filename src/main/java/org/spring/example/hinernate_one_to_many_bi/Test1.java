package org.spring.example.hinernate_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hinernate_one_to_many_bi.entity.Department;
import org.spring.example.hinernate_one_to_many_bi.entity.Employee;


public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration() //можно создать один раз а потом его переиспользовать
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session=null;


        try {
//            session = factory.getCurrentSession();
//            Department dep=new Department("Sales", 800,1500);
//            Employee emp1=new Employee("Zaur", "Tregulov",800);
//            Employee emp2=new Employee("Elena", "Smirnova",1500);
//            Employee emp3=new Employee("Anton", "Sidorov",1200);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//            session.beginTransaction(); //открыли транзакцию
//            session.save(dep);
//            session.getTransaction().commit(); //закрыли транзакцию
            //*******************************************
            session = factory.getCurrentSession();
            session.beginTransaction(); //открыли транзакцию
            Department department=session.get(Department.class,3);
            System.out.println(department);
            System.out.println(department.getEmps());
            session.getTransaction().commit(); //закрыли транзакцию
            //*************************************************
//            session = factory.getCurrentSession();
//            session.beginTransaction(); //открыли транзакцию
//            Employee employee=session.get(Employee.class,1);
//            session.delete(employee); //если сделать так, то если каскад олл, то удалится вся инфа о таблицах, то есть если у раб depattment_id 1, то в таблице департаменов удалится строка с 1
//
//            session.getTransaction().commit(); //закрыли транзакцию
            //************************************************

        }
        finally {
            factory.close();
            session.close();
        }
    }
}
