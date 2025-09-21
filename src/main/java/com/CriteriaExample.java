package com;

import com.first.Student;
import com.mapping.xml.Person;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration(). configure().buildSessionFactory();


        Session session = factory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
      //  query.select(root);

        // Add filter (WHERE city = 'Pune')
       query.select(root).where(builder.equal(root.get("city"), "pune"));


        List<Student> results = session.createQuery(query).getResultList();
        for(Student st : results){
            System.out.println(st);
        }

    }
}
