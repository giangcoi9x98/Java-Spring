package com.example.demo.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class BaseController {
    private String name;
    @ModelAttribute("BeforeRequest")
    public  void beforeRequest(HttpServletRequest request, HttpServletResponse response){
        name = UUID.randomUUID().toString();
        System.out.println(name);
    }
}
