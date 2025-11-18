package edu.icet.repository;

import edu.icet.model.dto.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MemberRepository {
    public void addMember(Member member) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Member.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(member);
        transaction.commit();
    }

    public Member getMember(String id) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Member.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        return session.find(Member.class,id);
    }

    public void deleteMember(String id) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Member.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(session.find(Member.class,id));
        transaction.commit();
    }

    public void updateMember(Member member) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Member.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(member);
        transaction.commit();
    }

    public List<Member> getAll() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Member.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        List<Member> memberList = session.createQuery("FROM Member", Member.class).list();
        return memberList;
    }
}
