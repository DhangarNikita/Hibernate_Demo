package com.cache;

import com.first.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevel {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        Student student = session.get(Student.class, 102);
        System.out.println(student);
        System.out.println("Working Something");

        Student student1 = session.get(Student.class, 102);
        System.out.println(student1);

        System.out.println(session.contains(student));
        System.out.println(session.contains(student1));

        session.close();
    }
}
