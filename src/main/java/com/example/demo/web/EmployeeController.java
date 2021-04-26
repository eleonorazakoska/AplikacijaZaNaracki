package com.example.demo.web;

import com.example.demo.model.Employees;
import com.example.demo.model.Products;
import com.example.demo.service.EmployeeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getEmployees(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Employees> employees = this.employeeService.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("bodyContent", "employees");
        return "employees";
    }
}
