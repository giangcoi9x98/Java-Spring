package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    SearchRepository searchRepository;

    public List<Product>search(String keyword){
        try{
            return searchRepository.search(keyword);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
