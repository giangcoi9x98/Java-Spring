package com.example.demo.repository;

import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.Orders;
import com.example.demo.helper.mapper.OrderMapper;
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

    @Transactional(rollbackFor = Exception.class)
    public  void create(OrderRequest orderRequest){
        String orderID = UUID.randomUUID().toString();
        String sql = "Insert into `order`(orderId,username,price,status) values(?,?,?,?); ";
        String sqlOrder = "Insert into orderDetail(orderId,productId,quantity)values(?,?,?); ";
        jdbcTemplate.update(sql,orderID,orderRequest.getUsername(),orderRequest.getPrice(),orderRequest.getStatus());

        for(Orders orders : orderRequest.getOrders()){
            jdbcTemplate.update(sqlOrder,orderID,orders.getProductId(),orders.getQuantity());
        }

    }
    public List<Order> getAll(){
        String sql = "Select * from `order ;`";
        return jdbcTemplate.query(sql,new OrderMapper(),new Object[]{});
    }
}
