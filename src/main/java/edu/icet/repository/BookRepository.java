package edu.icet.repository;

import edu.icet.model.dto.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BookRepository {

    public void addBook(Book book) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Book.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
    }

    public Book getBook(String id) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Book.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        return session.find(Book.class,id);
    }

    public void deleteBook(String id) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Book.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(session.find(Book.class,id));
        transaction.commit();
    }

    public void updateBook(Book book) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Book.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(book);
        transaction.commit();
    }

    public List<Book> getAll() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(edu.icet.model.dto.Book.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        List<Book> bookList = session.createQuery("FROM Book", Book.class).list();
        return bookList;
    }
}
