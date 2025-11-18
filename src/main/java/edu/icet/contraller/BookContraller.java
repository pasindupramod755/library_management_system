package edu.icet.contraller;

import edu.icet.model.dto.Book;
import edu.icet.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookContraller {
    BookService bookService = new BookService();

    @PostMapping("add/book")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("get/book/{id}")
    public Book getBook(@PathVariable String id){
        return bookService.getBook(id);
    }

    @DeleteMapping("delete/book/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
    }

    @PostMapping("update/book")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @GetMapping("getAll")
    public List<Book> getAll(){
        return bookService.getAll();
    }

}
