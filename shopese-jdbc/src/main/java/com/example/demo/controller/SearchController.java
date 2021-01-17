package com.example.demo.controller;

import com.example.demo.helper.responseBuilder.ResponseForm;
import com.example.demo.model.Product;
import com.example.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/search")
public class SearchController {
    @Autowired
    SearchService searchService;
    @GetMapping()
    public ResponseEntity<ResponseForm<List<Product>>>search(@RequestParam(name="display") String keyword){
        List<Product> data =searchService.search(keyword);
        return ResponseEntity.ok(ResponseForm.responseOk(data,1,"OK"));
    }

}
