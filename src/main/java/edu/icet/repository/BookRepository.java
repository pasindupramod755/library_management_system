package edu.icet.repository;

import edu.icet.config.BookHibernateUtil;
import edu.icet.model.dto.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepository {

    Session session = BookHibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();

    public void addBook(Book book) {
        session.persist(book);
        transaction.commit();
    }

    public Book getBook(String id) {
        return session.find(Book.class,id);
    }

    public void deleteBook(String id) {
        session.remove(session.find(Book.class,id));
        transaction.commit();
    }

    public void updateBook(Book book) {
        session.merge(book);
        transaction.commit();
    }

    public List<Book> getAll() {
        List<Book> bookList = session.createQuery("FROM Book", Book.class).list();
        return bookList;
    }
}
