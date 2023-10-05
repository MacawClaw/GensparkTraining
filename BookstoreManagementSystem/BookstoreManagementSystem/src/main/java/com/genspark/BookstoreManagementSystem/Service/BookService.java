package com.genspark.BookstoreManagementSystem.Service;

import com.genspark.BookstoreManagementSystem.Dao.BookRepository;
import com.genspark.BookstoreManagementSystem.Entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    private final EntityManager entityManager;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(long id) {
        Optional<Book> b = bookRepository.findById(id);
        Book book = null;
        if (b.isPresent()) {
            book = b.get();
        } else {
            throw new RuntimeException(" Book not found for this id :: " + id);
        }
        return book;
    }

    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findBookByAuthor(String author) {
        //return bookRepository.findByAuthor(author);
        TypedQuery<Book> typedQuery = entityManager.createNamedQuery("Book.findByAuthor", Book.class);
        typedQuery.setParameter("author", author);

        return  typedQuery.getResultList();
    }

    public List<Book> findByPublicationYearRange(int startYear, int endYear) {
        //return bookRepository.findByPublicationYearRange(startYear, endYear);

        TypedQuery<Book> typedQuery = entityManager.createNamedQuery("Book.findByPublicationYearRange", Book.class);
        typedQuery.setParameter("startYear", startYear);
        typedQuery.setParameter("endYear", endYear);

        return  typedQuery.getResultList();
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public String deleteById(long id) {
        try {
            bookRepository.deleteById(id);
            return "Book: " + id + " Deleted Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
