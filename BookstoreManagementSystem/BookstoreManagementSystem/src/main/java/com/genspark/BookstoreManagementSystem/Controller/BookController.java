package com.genspark.BookstoreManagementSystem.Controller;

import com.genspark.BookstoreManagementSystem.Entity.Book;
import com.genspark.BookstoreManagementSystem.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return bookService.findById(id);
    }

    @GetMapping("/byTitle/{title}")
    public Book findBookByTitle(@PathVariable String title) {
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/byAuthor")
    public List<Book> findBookByAuthor(@RequestParam(value = "author") String author) {
        return bookService.findBookByAuthor(author);
    }

    @GetMapping("/byPublicationYearRange")
    public List<Book> findByPublicationYearRange(@RequestParam(value = "startYear") int startYear, @RequestParam(value = "endYear") int endYear) {
        return bookService.findByPublicationYearRange(startYear, endYear);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id) {
        return bookService.deleteById(id);
    }

}
