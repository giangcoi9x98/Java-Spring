package com.example.demo.repository;

import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.Orders;
import com.example.demo.helper.mapper.OrderMapper;
import com.example.demo.helper.mapper.ProductMapper;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ProductRespository productRespository;

    @Transactional(rollbackFor = Exception.class)
    public void create(OrderRequest orderRequest) {
        String orderID = UUID.randomUUID().toString();
        int price = 0;
        for (Orders orders : orderRequest.getOrders()) {
            int rs=getPrice(orders.getProductId());
            price+=rs*orders.getQuantity();
        }
        String sql = "Insert into `order`(orderId,username,price,status) values(?,?,?,?); ";
        String sqlOrder = "Insert into orderDetail(orderId,productId,quantity)values(?,?,?); ";
        jdbcTemplate.update(sql, orderID, orderRequest.getUsername(), price, orderRequest.getStatus());

        for (Orders orders : orderRequest.getOrders()) {
            jdbcTemplate.update(sqlOrder, orderID, orders.getProductId(), orders.getQuantity());
        }

    }

    public int getPrice(String id) {
       return productRespository.getProductById(id).getPriceOut();

    }

    public List<Order> getAll() {
        String sql = "Select * from `order`;";
        return jdbcTemplate.query(sql, new OrderMapper(), new Object[]{});
    }
}
