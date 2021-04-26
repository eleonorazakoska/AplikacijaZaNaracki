package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.model.Tables;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

public interface TablesService {

    Optional<Tables> findById(Long number);
    List<Tables> findAll();
    List<Order> listAllOrdersInTable(Long number);
    Boolean addOrderInTable(Long number, Long productId);
}
