package com.genspark.BookDB.Dao;

import com.genspark.BookDB.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book,Integer> {
}
