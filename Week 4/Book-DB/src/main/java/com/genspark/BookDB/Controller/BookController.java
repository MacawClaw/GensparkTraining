package com.genspark.BookDB.Controller;

import com.genspark.BookDB.Entity.Book;
import com.genspark.BookDB.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(){
        return "<HTML><H1>Welcome to the Book Application</H1></HTML>";
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        return this.bookService.getBookByIsbn(Integer.parseInt(isbn));
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        return this.bookService.updateBook(book);
    }

    @DeleteMapping("/books/{isbn}")
    public String deleteBook(@PathVariable String isbn) {
        return this.bookService.deleteBookByIsbn(Integer.parseInt(isbn));
    }
}
