package com.example.demo.repository;

import com.example.demo.helper.mapper.ProductMapper;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRespository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProduct(int type) {
        String sql = "call getAllProduct(?);";//id= 1 Sort ASC,orther sort DESC
        return jdbcTemplate.query(sql, new ProductMapper(), new Object[]{type});
    }

    public Product getProductById(String id) {
        String sql = "call getProductById(?)";
        return jdbcTemplate.queryForObject(sql, new ProductMapper(), new Object[]{id});
    }

    public void createProduct(String display, String description, int priceOut, int priceIn, int priceSale, String imageUrl
            , int instock) {
        String sql = "call createProduct(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, display, description, priceOut, priceIn, priceSale, imageUrl, instock);
    }
}
