package com.learn.bootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    Long id;
    String name;
    String type;
    String category;
    Long price;
}
