package com.example.demo.web;

import com.example.demo.model.Products;
import com.example.demo.model.Tables;
import com.example.demo.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {

        this.productService = productService;
    }


    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Products> products = this.productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("bodyContent", "products");
        return "products";
    }



    @GetMapping("/edit-form/{productId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editProductPage(@PathVariable Long productId, Model model) {
        if (this.productService.findById(productId).isPresent()) {
            Products product = this.productService.findById(productId).get();
            model.addAttribute("product", product);
            model.addAttribute("bodyContent", "add-product");
            return "add-product";
        }
        return "redirect:/products?error=ProductNotFound";

    }
    @PostMapping("/add/{productId}")
    public String editProduct(
            @RequestParam String name,
            @RequestParam Float price,
            @PathVariable Long productId
    ) {

        this.productService.edit(name, price, productId);
        return "redirect:/products";
    }


    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addProductPage(Model model){
        model.addAttribute("bodyContent", "add-product");
        return "add-product";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam String name,
            @RequestParam Float price,
            @RequestParam Long productId
    ) {

        this.productService.save(name, price, productId);
        return "redirect:/products";
    }



}
