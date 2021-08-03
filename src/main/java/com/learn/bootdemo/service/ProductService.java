package com.learn.bootdemo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.learn.bootdemo.entity.Product;
import com.learn.bootdemo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @PostConstruct
    void insertRecords(){
        productRepository.save(new Product(1l,"iphone","mobile","electronics",1000l));
        productRepository.save(new Product(2l,"one plus","mobile","electronics",100l));
    }
    
}
