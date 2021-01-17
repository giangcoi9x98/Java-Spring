package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRespository productRespository;

    public List<Product> getAllProduct(Integer type, String input) {
        try {
            if (type != null && input.isEmpty() == false) {
                return productRespository.getAllProduct(type, input);
            } else {
                return productRespository.getAllProduct();
            }
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
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        try {
            productRespository.updateProduct(product);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteProduct(String id) {
        try {
            productRespository.deleteProduct(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
