package com.example.demo.helper.mapper;

import com.example.demo.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getString("productId"));
        product.setDisplay(resultSet.getString("display"));
        product.setDescription(resultSet.getString("description"));
        product.setImageUrl(resultSet.getString("imageUrl"));
        product.setPricaIn(resultSet.getInt("priceIn"));
        product.setPriceOut(resultSet.getInt("priceOut"));
        product.setPriceSale(resultSet.getInt("priceSale"));
        product.setInstock(resultSet.getInt("instock"));
        return product;
    }
}
