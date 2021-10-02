package org.spring.example.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.example.hibernate_many_to_many.entity.Child;
import org.spring.example.hibernate_many_to_many.entity.Section;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session=null;
        try {
//            session=factory.getCurrentSession();
//            Section section1=new Section("Football");
//            Child child1=new Child("Zaur",5);
//            Child child2=new Child("Masha",7);
//            Child child3=new Child("Vasia",6);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//            session.beginTransaction();
//            session.persist(section1); //так как каскад не all, но надо писать не save a persist

//            session.getTransaction().commit();
//            System.out.println("Done");
            //------------------------------------------
//                        session=factory.getCurrentSession();
//            Section section1=new Section("Volleyball");
//            Section section2=new Section("Chess");
//            Section section3=new Section("Math");
//            Child child1=new Child("Igor",10);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//            session.beginTransaction();
//            session.save(child1);
//            session.getTransaction().commit();
//            System.out.println("Done");
            //********************************************
//            session=factory.getCurrentSession();
//
//            session.beginTransaction();
//            Section section=session.get(Section.class,1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//            System.out.println("Done");
            //**************************************************************
            session=factory.getCurrentSession();

            session.beginTransaction();
            Section section=session.get(Section.class,1);
     //       session.delete(section); //если так написать, то удалится не только секция, но все дети которые ее посещаю, это потому что каскад all
           session.delete(section);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
            session.close();

        }
        }
}
