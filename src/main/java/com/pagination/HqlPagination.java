package com.pagination;

import com.first.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Struct;
import java.util.List;

public class HqlPagination {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        String query ="from Student";
        Query q = (Query) session.createQuery(query);
        q.setFirstResult(0);
        q.setMaxResults(5);


        List<Student> list = q.list();
        for(Student st: list){
            System.out.println(st.getName()+" "+st.getCity());
        }
        session .close();
        factory.close();
    }
}
