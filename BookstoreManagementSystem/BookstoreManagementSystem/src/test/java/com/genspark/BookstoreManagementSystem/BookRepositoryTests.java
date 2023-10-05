package com.genspark.BookstoreManagementSystem;

import com.genspark.BookstoreManagementSystem.Dao.BookRepository;
import com.genspark.BookstoreManagementSystem.Entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BookRepositoryTests {

    @Autowired
    private BookRepository repo;

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setAuthor("Toni Morrison");
        book.setTitle("Beloved");
        book.setPublicationYear(1987);
        book.setPrice(new BigDecimal("12.99"));
        Book savedBook = repo.save(book);
        assertThat(savedBook.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindByAuthor() {
        List<Book> list = repo.findByAuthor("Toni Morrison");
        System.out.println(list);
    }

    @Test
    public void testFindByYear() {
        List<Book> list = repo.findByPublicationYearRange(1900, 1950);
        System.out.println(list);
    }
}
