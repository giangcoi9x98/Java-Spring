package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.helper.responseBuider.ResponseForm;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class AuthorController extends BaseController{
    @Autowired
    AuthorService authorService;


    @GetMapping(value = "author")
    public ResponseEntity <ResponseForm<List<Author>>>getAll(){
        List<Author>authors = authorService.getAll();
        return ResponseEntity.ok(ResponseForm.responseOkBuider(authors,1,"ok"));
    }
}
