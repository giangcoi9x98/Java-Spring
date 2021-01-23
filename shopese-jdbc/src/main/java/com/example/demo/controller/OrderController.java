package com.example.demo.controller;

import com.example.demo.dto.OrderRequest;
import com.example.demo.helper.responseBuilder.ResponseForm;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/order")
    public ResponseEntity<ResponseForm<Boolean>> create(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(ResponseForm.responseOk(orderService.create(orderRequest), 1, "ok"));
    }

    @GetMapping(value = "/order")
    public ResponseEntity<ResponseForm<List<Order>>> getAll() {
        return ResponseEntity.ok(ResponseForm.responseOk(orderService.getAll(), 1, "ok"));
    }
}

