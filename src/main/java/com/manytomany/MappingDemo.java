package com.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Emp e1 = new Emp();
        Emp e2 = new Emp();

        e1.setEid(101);
        e1.setName("Nikita");
        e2.setEid(102);
        e2.setName("Ruchita");

        Project p1 = new Project();
        Project p2 = new Project();

        p1.setPid(1);
        p1.setProjectName("Java");
        p2.setPid(2);
        p2.setProjectName("Python");

        List<Emp> list1 = new ArrayList<>();
        List<Project> list2 = new ArrayList<>();

        list1.add(e1);
        list1.add(e2);

        list2.add(p1);
        list2.add(p2);

        e1.setProject(list2);
        p2.setEmp(list1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();

    }
}
