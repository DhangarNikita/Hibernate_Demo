package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {
    public static void main(String[] args) {
        System.out.println("Start");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Question qs = new Question();
        Answer as = new Answer();

        qs.setQuestionId(1);
        qs.setQuestion("What is java");

        as.setAnswerId(101);
        as.setAnswer("Java is a programming language");

        qs.setAnswer(as);

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(qs);
        session.save(as);
        tx.commit();

        Question q = (Question)session.get(Question.class,1);
        System.out.println(q.getQuestion());
        System.out.println(q.getAnswer().getAnswer());
        /*q.getAnswer() returns the Answer object linked to this Question.
       Then .getAnswer() is called on that Answer object, probably returning the answer text, e.g., "Java is a programming language.".*/
        session.close();
        factory.close();




    }
}
