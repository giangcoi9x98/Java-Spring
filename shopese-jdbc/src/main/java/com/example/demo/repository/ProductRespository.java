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

    public List<Product> getAllProduct(int sort, String sort_by) {
        String sql = "call getAllProduct(?,?);";
        return jdbcTemplate.query(sql, new ProductMapper(), new Object[]{sort, sort_by});
    }

    public List<Product> getAllProduct() {
        String sql = "Select * from product where isDelete =0;";
        return jdbcTemplate.query(sql, new ProductMapper(), new Object[]{});
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

    public void updateProduct(Product product) {
        String sql = "call updateProduct(?,?,?,?,?,?,?,?);";
        jdbcTemplate.update(sql, product.getProductId(), product.getDisplay(),
                product.getDescription(), product.getPriceIn(), product.getPriceOut(), product.getPriceSale()
                , product.getImageUrl(), product.getInstock());
    }

    public void deleteProduct(String id){
        String sql="call deleteProduct(?);";
        jdbcTemplate.update(sql,id);
    }
}
