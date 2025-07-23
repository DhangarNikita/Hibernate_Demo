package com.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        //get 101
        Student student = (Student) session.get(Student.class, 102);
        //Student student = (Student) session.load(Student.class, 102);
        System.out.println(student);

        //load
        Address ad = (Address) session.load(Address.class,2);
        System.out.println(ad.getCity());
        session.close();
        factory.close();

    }
}
