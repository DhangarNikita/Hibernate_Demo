package com.hql;

import com.first.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;


public class HqlExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        //String query ="from Student";
        String query ="from Student where city='Mumbai'";  //city:=X
        Query q = (Query) session.createQuery(query);
        // q.setParameter("X","Mumbai");

        List<Student> list = q.list();

        for(Student st :list){
            System.out.println(st.getName());
        }

        System.out.println("--------------------------------------------------");

        Transaction tx = session.beginTransaction();
        // Delete Query
        /*Query q2 = session.createQuery("delete from Student s where s.city=:c");
        q2.setParameter("c","pune");
        int r = q2.executeUpdate();
        System.out.println("Delete");
        System.out.println(r);*/

     /*   // Update Query

        Query q3= session.createQuery("update Student set city =:c where name=:n");
        q3.setParameter("c","Mumbai");
        q3.setParameter("n","Sneha");
        int r = q3.executeUpdate();
        System.out.println(r);
        tx.commit();
        session.close();
        factory.close();

        */

        // Inner Join

        Query q4 = session.createQuery("select q.question, q.questionId, a.answer from Question1 q INNER JOIN q.answers a");
        List <Object[]> list3 = q4.getResultList();

        for(Object [] arr : list3){
            System.out.println(Arrays.toString(arr));
        }
        session.close();
        factory.close();
    }
}
