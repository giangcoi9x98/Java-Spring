package com.example.demo.repository;

import com.example.demo.helper.mapper.ProductMapper;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product>search(String keyword){
        String sql = "Call search(?);";
        return jdbcTemplate.query(sql,new ProductMapper(),new Object[]{keyword});
    }

}
