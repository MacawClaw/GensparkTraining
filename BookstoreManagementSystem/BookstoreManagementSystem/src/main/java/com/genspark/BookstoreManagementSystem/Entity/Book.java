package com.genspark.BookstoreManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="books")
@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
@NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")
@NamedQuery(name = "Book.findByPublicationYearRange", query = "SELECT b FROM Book b WHERE b.publicationYear BETWEEN :startYear AND :endYear")
@NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private BigDecimal price;

    private int publicationYear;

}
