package com.genspark.BookstoreManagementSystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genspark.BookstoreManagementSystem.Dao.BookRepository;
import com.genspark.BookstoreManagementSystem.Entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BookRepository repo;

    @Test
    public void testFindBooksByAuthor() throws Exception {
        String url = "/books/byAuthor?author=Toni Morrison";

        MvcResult result = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Book[] books = objectMapper.readValue(jsonResponse, Book[].class);

        assertThat(books).hasSizeGreaterThan(0);
    }

    @Test
    public void testFindBooksByYearRange() throws Exception {
        String url = "/books/byPublicationYearRange?startYear=1950&endYear=2020";

        MvcResult result = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Book[] books = objectMapper.readValue(jsonResponse, Book[].class);

        assertThat(books).hasSizeGreaterThan(0);
    }

    @Test
    public void testCreateBook() throws Exception {
        String url = "/books";

        Book book = new Book(null, "A Doll's House", "Henrik Ibsen", new BigDecimal(28.99), 1879);

        MvcResult result = mockMvc.perform(post(url).contentType("application/json")
                        .content(objectMapper.writeValueAsString(book)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        //System.out.println("book: " + response);

        Book savedBook = objectMapper.readValue(response, Book.class);
        //System.out.println("book: " + savedBook);

        assertThat(savedBook.getId()).isGreaterThan(0);
    }

    @Test
    public void testUpdateBook() throws JsonProcessingException, Exception {
        String url = "/books";

        Long bookId = 8l;
        String bookTitle = "A Doll's House";
        String bookAuthor = "Henrik Ibsen";
        BigDecimal bookPrice = new BigDecimal(15.99);
        int year = 1879;

        Book book = new Book(bookId, bookTitle, bookAuthor, bookPrice, year);

        mockMvc.perform(put(url).contentType("application/json")
                        .content(objectMapper.writeValueAsString(book)))
                .andDo(print())
                .andExpect(status().isOk());

        Optional<Book> findById = repo.findById(bookId);
        assertThat(findById.isPresent());

        Book savedBook = findById.get();
        assertThat(savedBook.getTitle()).isEqualTo(bookTitle);
    }
}
