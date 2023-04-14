package com.genspark.BookDB.Service;

import com.genspark.BookDB.Entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();


    Book getBookByIsbn(int isbn);

    Book addBook(Book book);

    Book updateBook(Book book);

    String deleteBookByIsbn(int isbn);
}
