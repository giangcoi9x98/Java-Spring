package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/demo")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(value = "book")
    @ResponseBody()
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping(value = "book")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean create(@RequestBody Book book) {
        return bookService.create(book.getName(), book.getAuthorId());
    }

    @PutMapping(value = "book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean update(@RequestBody Book book, @PathVariable int id) {
        return bookService.update(id, book.getName(), book.getAuthorId());
    }

    @DeleteMapping(value = "book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable int id) {
        return bookService.delete(id);
    }
}
