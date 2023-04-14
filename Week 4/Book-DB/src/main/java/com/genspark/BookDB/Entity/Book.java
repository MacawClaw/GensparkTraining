package com.genspark.BookDB.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    //ISBN used as Id
    @Id
    @Column(name = "isbn")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int isbn;

    @NonNull
    private String title;

    @NonNull
    private String author;

    @NonNull
    private String genre;

    @NonNull
    private String description;
}
