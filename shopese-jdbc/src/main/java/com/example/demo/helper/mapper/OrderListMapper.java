package com.example.demo.helper.mapper;

import com.example.demo.dto.Orders;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderListMapper implements RowMapper<Orders> {

    @Override
    public Orders mapRow(ResultSet resultSet, int i) throws SQLException {
        Orders orders= new Orders();
        orders.setQuantity(resultSet.getInt("quantity"));
        orders.setProductId(resultSet.getString("productId"));
        return orders;
    }
}
