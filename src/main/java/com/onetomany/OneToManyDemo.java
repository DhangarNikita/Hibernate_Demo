package com.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToManyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Question1 q1 = new Question1();
        q1.setQuestionId(101);
        q1.setQuestion("What is java");

        Answer1 a1 =new Answer1();
        a1.setAnswerId(1);
        a1.setAnswer("Java is a programming language");
        a1.setQuestion1(q1);

        Answer1 a2 =new Answer1();
        a2.setAnswerId(2);
        a2.setAnswer("Java is platform independent");
        a2.setQuestion1(q1);

        List<Answer1> list =new ArrayList<>();
        list.add(a1);
        list.add(a2);

        q1.setAnswers(list);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);
        session.save(a1);
        session.save(a2);

        Question1 q = session.get(Question1.class,101);
        System.out.println(q.getQuestion());

        for(Answer1 a : q.getAnswers()){
            System.out.println(a.getAnswer());
        }

        tx.commit();

        session.close();
        factory.close();


    }
}
