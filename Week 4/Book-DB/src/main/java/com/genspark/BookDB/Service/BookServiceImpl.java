package com.genspark.BookDB.Service;

import com.genspark.BookDB.Dao.BookDao;
import com.genspark.BookDB.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooks(){
        return this.bookDao.findAll();
    }

    //ISBN used as Id, findById method given by dependencies within findbyIsbn
    @Override
    public Book getBookByIsbn(int isbn){
        Optional <Book> b = this.bookDao.findById(isbn);
        Book book = null;
        if(b.isPresent()) {
            book = b.get();
        } else {
            throw new RuntimeException("Book not found for isbn :: " + isbn);
        }

        return book;
    }

    @Override
    public Book addBook(Book book){
        return this.bookDao.save(book);
    }

    @Override
    public Book updateBook(Book book){
        return this.bookDao.save(book);

    }

    @Override
    public String deleteBookByIsbn(int isbn){
        this.bookDao.deleteById(isbn);
        return "Deleted Successfully";
    }

}
