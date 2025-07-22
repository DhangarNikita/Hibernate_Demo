package com.states;

import com.first.Certificate;
import com.first.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Student student = new Student();
        student.setId(105);
        student.setName("Swati");
        student.setCity("Delhi");
        student.setCerti(new Certificate(3,"Java"));
        //Object is in Transient state

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student); // object associate with database and session this means object is in persistent state

        student.setName("Trisha");
        tx.commit();

        session.close();
        // detached state
        student.setName("Priya"); // not reflected in database because object is not associated with session

        factory.close();
    }
}
