package com.example.demo.repository;
import com.example.demo.helper.mapper.BookMapper;
import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository extends JdbcDaoSupport {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public BookRepository(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Book> getAll() {
        String sql = "Select * from book";
        return this.getJdbcTemplate().query(sql, new Object[]{}, new BookMapper());
    }

    public Book getById(int id) {
        String sql = "Select * from book where id= ?";
        Object[] params = new Object[]{id};
        BookMapper bookRowMapper = new BookMapper();
        Book book = this.getJdbcTemplate().queryForObject(sql, params, bookRowMapper);
        return book;
    }
    public void create(String name,int author_id){
        String sql = "Insert into book values(0,?,?)";
       this.getJdbcTemplate().update(sql,name,author_id);
    }

}
