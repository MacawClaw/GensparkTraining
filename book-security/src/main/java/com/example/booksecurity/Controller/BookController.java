package com.example.booksecurity.Controller;

import com.example.booksecurity.Entity.Book;
import com.example.booksecurity.Service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @GetMapping("public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("<HTML><H1>I am a public user</H1></HTML>");
    }

    //@MustBeAdmin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("<HTML><H1>I am an Admin</H1></HTML>");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("normal")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("<HTML><H1>I am a Normal User</H1></HTML>");
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("books")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("books/{upc}")
    public ResponseEntity<Book> getBook(@PathVariable String upc) {
        return ResponseEntity.ok(this.bookService.getBookByUpc(Integer.parseInt(upc)));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(this.bookService.addBook(book));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(this.bookService.updateBook(book));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("books/{upc}")
    public ResponseEntity<String> deleteBook(@PathVariable String upc) {
        return ResponseEntity.ok(this.bookService.deleteBookByUpc(Integer.parseInt(upc)));
    }
}
