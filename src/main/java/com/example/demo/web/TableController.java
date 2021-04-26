package com.example.demo.web;

import com.example.demo.model.Order;
import com.example.demo.model.Products;
import com.example.demo.model.Tables;
import com.example.demo.service.ProductService;
import com.example.demo.service.TablesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/table")
public class TableController {

    private final TablesService tablesService;
    private final ProductService productService;



    public TableController(TablesService tablesService, ProductService productService) {
        this.tablesService = tablesService;
        this.productService = productService;
    }



    @GetMapping("/{id}/orders")
    public String ordersByTable(@PathVariable("id") Long number, Model model) {
        try {
            List<Order> orders =  this.tablesService.listAllOrdersInTable(number);
            Optional<Tables> table = this.tablesService.findById(number);
            model.addAttribute("orders", orders);
            model.addAttribute("table", table.get());
            return "table";
        }
        catch (RuntimeException exception) {
            return "redirect:/table?error=" + exception.getMessage();
        }

    }


    @GetMapping("/{id}/orders/new")
    public String newOrderByTable(@PathVariable("id") Long number, Model model) {
        try {
            List<Products> products =  this.productService.findAll();
            model.addAttribute("products", products);
            return "products";
        }
        catch (RuntimeException exception) {
            return "redirect:/table?error=" + exception.getMessage();
        }

    }


    @PostMapping("/{id}/orders/new")
    public String addNewOrderByTable(@PathVariable("id") Long number, @RequestParam("Product") Long product, Model model) {
        this.tablesService.addOrderInTable(number, product);
        return "redirect:/table/"+number+"/orders";

    }




}
