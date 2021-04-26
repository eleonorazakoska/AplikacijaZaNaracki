package com.example.demo.web;

import com.example.demo.model.Products;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }


    @PostMapping("/add-product/{productId}")
    public String addProductInOrder(@PathVariable Long orderId, @PathVariable Long productId,
            HttpServletRequest req) {
        try {
            this.orderService.addProductInOrder(orderId, productId);
            return "redirect:/table";
        } catch (RuntimeException exception) {
            return "redirect:/table?error=" + exception.getMessage();
        }
    }


}
