package com.example.booksecurity.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    //Universal Product Number used as Id
    @Id
    @Column(name = "upc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int upc;

    @NonNull
    private String title;

    @NonNull
    private String author;

    @NonNull
    private BigDecimal price;

    @NonNull
    private String publicationYear;
}
