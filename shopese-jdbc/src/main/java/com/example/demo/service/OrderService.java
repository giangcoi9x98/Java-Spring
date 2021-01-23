package com.example.demo.service;

import com.example.demo.dto.OrderRequest;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public boolean create(OrderRequest orderRequest) {
        try {
            orderRepository.create(orderRequest);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Order> getAll() {
        try {
            return orderRepository.getAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
