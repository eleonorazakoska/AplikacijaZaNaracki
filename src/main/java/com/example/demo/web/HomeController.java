package com.example.demo.web;

import com.example.demo.model.Products;
import com.example.demo.model.Tables;
import com.example.demo.service.ProductService;
import com.example.demo.service.TablesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
//@RequestMapping("/home")
public class HomeController {

    private final TablesService tablesService;
    private final ProductService productService;


    public HomeController(TablesService tablesService, ProductService productService){
        this.tablesService = tablesService;
        this.productService = productService;
    }

    @GetMapping({"/","/home"})
    public String getHomePage(Model model){
        List<Tables>tables = tablesService.findAll();
        model.addAttribute("tables",tables);
        return "home";
    }
    /*@GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Products> products = this.productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }*/








}
