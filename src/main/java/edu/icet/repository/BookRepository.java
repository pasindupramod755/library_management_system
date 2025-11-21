package edu.icet.repository;

import edu.icet.config.BookHibernateUtil;
import edu.icet.model.dto.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepository {

    Session session = BookHibernateUtil.getSessionFactory().openSession();

    public void addBook(Book book) {
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
    }

    public Book getBook(String id) {
        return session.find(Book.class,id);
    }

    public void deleteBook(String id) {
        Transaction transaction = session.beginTransaction();
        session.remove(session.find(Book.class,id));
        transaction.commit();
    }

    public void updateBook(Book book) {
        Transaction transaction = session.beginTransaction();
        session.merge(book);
        transaction.commit();
    }

    public List<Book> getAll() {
        List<Book> bookList = session.createQuery("FROM Book", Book.class).list();
        return bookList;
    }
}
