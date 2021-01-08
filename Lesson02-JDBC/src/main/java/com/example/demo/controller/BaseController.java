package com.example.demo.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Data
public class BaseController {
    private  String name;
    @ModelAttribute("BeforeRequest")
    public void beforeRequest(HttpServletRequest request, HttpServletResponse response){
        name = "Giang";
        System.out.println("before");
    }


}
