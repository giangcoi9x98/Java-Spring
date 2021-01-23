package com.example.demo.helper.mapper;

import com.example.demo.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order  = new Order();
        order.setOrderId(resultSet.getString("orderId"));
        order.setUsername(resultSet.getString("username"));
        order.setPrice(resultSet.getInt("price"));
        order.setStatus(resultSet.getString("status"));
        return order;
    }
}
