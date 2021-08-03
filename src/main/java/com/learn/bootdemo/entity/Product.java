package com.learn.bootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

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
    @NotBlank( message = "Name cannot be left empty")
    String name;
    String type;
    String category;
    @Positive
    Long price;
}
