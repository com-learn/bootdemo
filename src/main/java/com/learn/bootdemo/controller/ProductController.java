package com.learn.bootdemo.controller;

import java.util.List;

import com.learn.bootdemo.entity.Product;
import com.learn.bootdemo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("/api/bootdemo")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    @Operation( summary = "List All Products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
}
