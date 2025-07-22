package com.cache;


import com.first.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session1 = factory.openSession();
        // First
       Student st1 = session1.get(Student.class, 102);
        System.out.println(st1);
        session1.close();

        Session session2 = factory.openSession();
        // Second
        Student st2 = session2.get(Student.class, 102);
        System.out.println(st2);
    }
}
