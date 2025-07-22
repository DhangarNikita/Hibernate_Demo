package com.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Project Started");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student st = new Student();
        st.setId(102);
        st.setCity("Mumbai");
        st.setName("Sneha");

        Certificate cf = new Certificate();
        cf.setCource("Core Java");
        cf.setDuration(1);
        st.setCerti(cf);
        System.out.println(st);

        Address ad = new Address();
        ad.setStreet("Street1");
        ad.setCity("Pune");
        ad.setOpen(true);
        ad.setAddeddate(new Date());
        ad.setX(12547.3254);


        Student st1 = new Student();
        st1.setId(108);
        st1.setCity("pune");
        st1.setName("Nikita");

        Certificate cf1 = new Certificate();
        cf1.setCource("Core Java");
        cf1.setDuration(2);
        st1.setCerti(cf1);
        System.out.println(st1);

        Address ad1 = new Address();
        ad1.setStreet("Street1");
        ad1.setCity("Latur");
        ad1.setOpen(true);
        ad1.setAddeddate(new Date());
        ad1.setX(12547.3254);



        FileInputStream file = new FileInputStream("src/main/java/Demo.png");  //image
        byte[] data = new byte[file.available()];
        file.read(data);
        ad.setImage(data);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);

        session.save(st1);
        session.save(ad1);
        tx.commit();
        session.close();
        System.out.println("Done");

    }
}
