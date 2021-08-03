package com.learn.bootdemo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import com.learn.bootdemo.entity.Product;
import com.learn.bootdemo.exception.ResourceNotFoundException;
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

    public Product getProductById(Long id) throws ResourceNotFoundException{
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found", LocalDateTime.now()));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    @PostConstruct
    void insertRecords(){
        productRepository.save(new Product(1l,"iphone","mobile","electronics",1000l));
        productRepository.save(new Product(2l,"one plus","mobile","electronics",100l));
    }
    
}
