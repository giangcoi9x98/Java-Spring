package com.example.demo.controller;

import com.example.demo.helper.responseBuilder.ResponseForm;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<ResponseForm<List<Product>>> getAll(@RequestParam int id,@RequestParam String input) {
        List<Product> data = productService.getAllProduct(id,input);
        return ResponseEntity.ok(ResponseForm.responseOk(data, 1, "Ok"));
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ResponseForm<Product>> getById(@PathVariable String id) {
        return ResponseEntity.ok(ResponseForm.responseOk(productService.getProductById(id), 1, "ok"));
    }

    @PostMapping(value = "product")
    public ResponseEntity<ResponseForm<Boolean>> create(@RequestBody Product product) {
        System.out.println(product);
        return ResponseEntity.ok(ResponseForm.responseOk(productService.createProduct(product.getDisplay(), product.getDescription()
                , product.getPriceOut(), product.getPricaIn(), product.getPriceSale(), product.getImageUrl(), product.getInstock()), 1, "ok"));

    }

}
