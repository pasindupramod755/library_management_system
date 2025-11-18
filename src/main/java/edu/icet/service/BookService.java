package edu.icet.service;

import edu.icet.model.dto.Book;
import edu.icet.repository.BookRepository;

import java.util.List;

public class BookService {
    BookRepository bookRepository = new BookRepository();

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public Book getBook(String id) {
        return bookRepository.getBook(id);
    }


    public void deleteBook(String id) {
        bookRepository.deleteBook(id);
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }
}
