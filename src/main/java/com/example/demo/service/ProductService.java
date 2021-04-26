package com.example.demo.service;

import com.example.demo.model.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Products>findById(Long productId);
    List<Products> findAll();
    void deleteById(Long productId);
    Optional<Products> save(String productName, Float price, Long productId);
    Optional<Products> edit(String productName, Float price, Long productId);
}
