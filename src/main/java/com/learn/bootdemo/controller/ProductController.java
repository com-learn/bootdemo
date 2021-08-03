package com.learn.bootdemo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import com.learn.bootdemo.entity.Product;
import com.learn.bootdemo.exception.ResourceNotFoundException;
import com.learn.bootdemo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@Validated
@RequestMapping("/api/bootdemo")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    @Operation( summary = "List All Products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    @Operation( summary = "Get a Product")
    public ResponseEntity<Product> getProduct(@PathVariable @Positive Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @PostMapping("/products")
    @Operation( summary="Create a Product")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }
}
