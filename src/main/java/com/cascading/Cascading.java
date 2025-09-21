package com.cascading;

import com.onetomany.Answer1;
import com.onetomany.Question1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Cascading {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();


        Question1 q1 = new Question1();
        q1.setQuestionId(202);
        q1.setQuestion("What is jvm");

        Answer1 a1 = new Answer1(11, "jvm stands for java virtual machine", q1);
        Answer1 a2 = new Answer1(12, "is a platform dependent", q1);

        List<Answer1> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);

        q1.setAnswers(list);

        Transaction tx = session.beginTransaction();

        session.save(q1);

        tx.commit();
        session.close();
        factory.close();
    }
}
