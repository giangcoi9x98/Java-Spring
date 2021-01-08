package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRespository productRespository;

    public List<Product> getAllProduct(int type,String input) {
        try {
            return productRespository.getAllProduct(type,input);
        } catch (Exception e) {
            return null;
        }
    }

    public Product getProductById(String id) {
        try {
            return productRespository.getProductById(id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean createProduct(String display, String description, int priceOut, int priceIn, int priceSale, String imageUrl
            , int instock) {
        try {
            productRespository.createProduct(display, description, priceOut, priceIn, priceSale, imageUrl, instock);
            return  true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
