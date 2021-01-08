package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAll() {
        try {
            return bookRepository.getAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public Book getById(int id){
        try{
            return bookRepository.getById(id);
        }catch (Exception e ){
            System.out.println(e);
            return null;
        }
    }
    public  void create (String name,int author_id){
        try{
            bookRepository.create(name,author_id);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
