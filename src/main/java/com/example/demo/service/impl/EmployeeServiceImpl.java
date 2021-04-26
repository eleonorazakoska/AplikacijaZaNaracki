package com.example.demo.service.impl;

import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeesRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeesRepository employeesRepository;

    public EmployeeServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }


    @Override
    public List<Employees> findAll() {
        return this.employeesRepository.findAll();
    }



}
