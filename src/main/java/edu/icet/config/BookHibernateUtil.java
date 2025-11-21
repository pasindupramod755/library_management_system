package edu.icet.config;

import edu.icet.model.dto.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookHibernateUtil {
    private static Configuration configuration = new Configuration();
    private static SessionFactory SessionFactory;

    public static SessionFactory getSessionFactory(){
        if (SessionFactory == null){
            configuration.configure();
            configuration.addAnnotatedClass(Book.class);
            SessionFactory = configuration.buildSessionFactory();
        }
        return SessionFactory;
    }
}
