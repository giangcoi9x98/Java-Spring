package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.helper.responseBuider.ResponseForm;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class BookController extends BaseController {
    @Autowired
    BookService bookService;
    @GetMapping(value = "book")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @GetMapping("home")
    public  String home(){
        return "home";
    }

//    @GetMapping(value = "bookid")
//    public Book getById(@RequestParam int id){
//        return bookService.getById(id);
//    }
    @GetMapping(value = "book/{id}")
    public ResponseEntity<ResponseForm<Book>> getById(@PathVariable int id){
        Book  book = bookService.getById(id);
        return ResponseEntity.ok(ResponseForm.responseOkBuider(book,1,"ok"));
    }
//    public  Book getbyId (@PathVariable int id){
//        return bookService.getById(id);
//    }
    @PostMapping(value = "book")
    public ResponseEntity<ResponseForm<Book>>create(@RequestBody Book book){
        bookService.create(book.getName(),book.getAuthorId());
        return ResponseEntity.ok(ResponseForm.responseOkBuider(book,1,"ok"));
    }
    @GetMapping(value = "before")
    public String test(){
        return this.getName();
    }
}
