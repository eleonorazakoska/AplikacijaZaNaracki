package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Products;

import java.util.Optional;

public interface OrderService {


    Optional<Products> getProductById(Long productId);
    Optional<Order> addProductInOrder(Long orderId, Long productId);


}
