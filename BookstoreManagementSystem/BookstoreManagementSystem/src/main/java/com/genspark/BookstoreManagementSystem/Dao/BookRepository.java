package com.genspark.BookstoreManagementSystem.Dao;

import com.genspark.BookstoreManagementSystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Book findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByPublicationYearRange(int startYear, int endYear);


}
