package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.model.Products;
import com.example.demo.model.exceptions.ProductNotFoundException;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;



    public OrderServiceImpl(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;

    }


    @Override
    public Optional<Products> getProductById(Long productId) {
        return productService.findById(productId);
    }

    @Override
    public Optional<Order> addProductInOrder(Long orderId, Long productId){
        Optional<Order> order = this.orderRepository.findById(orderId);
        Products product = this.productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        order.get().setProduct(product);
        return order;


    }




}
