package com.example.booksecurity.Service;

import com.example.booksecurity.Entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();


    Book getBookByUpc(int upc);

    Book addBook(Book book);

    Book updateBook(Book book);

    String deleteBookByUpc(int upc);
}
