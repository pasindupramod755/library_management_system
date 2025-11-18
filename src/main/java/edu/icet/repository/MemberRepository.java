package edu.icet.repository;

import edu.icet.config.MemberHibernateUtil;
import edu.icet.model.dto.Member;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MemberRepository {

    Configuration config = new Configuration();
    Session session = MemberHibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    public void addMember(Member member) {
        session.persist(member);
        transaction.commit();
    }

    public Member getMember(String id) {
        return session.find(Member.class,id);
    }

    public void deleteMember(String id) {
        session.remove(session.find(Member.class,id));
        transaction.commit();
    }

    public void updateMember(Member member) {
        session.merge(member);
        transaction.commit();
    }

    public List<Member> getAll() {
        List<Member> memberList = session.createQuery("FROM Member", Member.class).list();
        return memberList;
    }
}
