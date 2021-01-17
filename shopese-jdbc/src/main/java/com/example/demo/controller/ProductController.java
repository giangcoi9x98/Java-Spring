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
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProductController extends BaseController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<ResponseForm<List<Product>>> getAll(@RequestParam(name = "sort", required = false) Integer sort, @RequestParam(name = "sort_by", required = false) String sort_by) {
        List<Product> data = productService.getAllProduct(sort, sort_by);
        return ResponseEntity.ok(ResponseForm.responseOk(data, 1, "Ok"));

    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ResponseForm<Product>> getById(@PathVariable String id) {
        return ResponseEntity.ok(ResponseForm.responseOk(productService.getProductById(id), 1, "ok"));
    }

    @PostMapping(value = "/product")
    public ResponseEntity<ResponseForm<Boolean>> create(@RequestBody Product product) {
        System.out.println(product);
        return ResponseEntity.ok(ResponseForm.responseOk(productService.createProduct(product.getDisplay(), product.getDescription()
                , product.getPriceOut(), product.getPriceIn(), product.getPriceSale(), product.getImageUrl(), product.getInstock()), 1, "ok"));

    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity<ResponseForm<Boolean>> update(@RequestBody Product product,@PathVariable String id) {
        return ResponseEntity.ok(ResponseForm.responseOk(productService.updateProduct(product), 1, "ok"));
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<ResponseForm<Boolean>>delete(@PathVariable String id){
        return ResponseEntity.ok(ResponseForm.responseOk(productService.deleteProduct(id),1,"ok"));
    }
}
