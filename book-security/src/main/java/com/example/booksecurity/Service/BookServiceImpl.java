package com.example.booksecurity.Service;

import com.example.booksecurity.Dao.BookDao;
import com.example.booksecurity.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooks(){
        return this.bookDao.findAll();
    }

    //UPC used as Id, findById method given by dependencies within findbyUpc
    @Override
    public Book getBookByUpc(int upc){
        Optional <Book> p = this.bookDao.findById(upc);
        Book book = null;
        if(p.isPresent()) {
            book = p.get();
        } else {
            throw new RuntimeException("Product not found for upc :: " + upc);
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
    public String deleteBookByUpc(int upc){
        this.bookDao.deleteById(upc);
        return "Deleted Successfully";
    }

}
