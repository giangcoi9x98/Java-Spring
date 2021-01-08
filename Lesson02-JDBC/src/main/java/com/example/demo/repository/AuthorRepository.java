package com.example.demo.repository;

import com.example.demo.entity.Author;
import com.example.demo.helper.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Author>getAll(){
        String sql = "Select * from author;";
        return jdbcTemplate.query(sql,new Object[]{},new AuthorMapper());
    }
}
