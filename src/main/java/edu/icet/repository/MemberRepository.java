package edu.icet.repository;

import edu.icet.config.MemberHibernateUtil;
import edu.icet.model.dto.Member;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MemberRepository {

    Session session = MemberHibernateUtil.getSessionFactory().openSession();

    public void addMember(Member member) {
        session.persist(member);
        Transaction transaction = session.beginTransaction();
        transaction.commit();
    }

    public Member getMember(String id) {
        return session.find(Member.class, id);
    }

    public void deleteMember(String id) {
        session.remove(session.find(Member.class, id));
        Transaction transaction = session.beginTransaction();
        transaction.commit();
    }

    public void updateMember(Member member) {
        session.merge(member);
        Transaction transaction = session.beginTransaction();
        transaction.commit();
    }

    public List<Member> getAll() {
        List<Member> memberList = session.createQuery("FROM Member", Member.class).list();
        return memberList;
    }
}
