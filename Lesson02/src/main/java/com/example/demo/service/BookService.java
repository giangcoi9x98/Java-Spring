package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public boolean create(String name, int authorId) {
        try {
            bookRepository.save(new Book(0, name, authorId));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(int id, String name, int authorId) {
        try {
            Book newBook = new Book();
            newBook.setName(name);
            newBook.setAuthorId(authorId);
            newBook.setId(id);
            bookRepository.save(newBook);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id){
        try{
            bookRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

}
