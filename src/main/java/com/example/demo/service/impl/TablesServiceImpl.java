package com.example.demo.service.impl;

import com.example.demo.model.Order;
import com.example.demo.model.Products;
import com.example.demo.model.Tables;
import com.example.demo.model.exceptions.TableNotFoundException;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.repository.TablesRepository;
import com.example.demo.service.TablesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesServiceImpl implements TablesService {
    private final TablesRepository tablesRepository;
    private final OrderRepository orderRepository;
    private final ProductsRepository productsRepository;


    public TablesServiceImpl(TablesRepository tablesRepository, OrderRepository orderRepository, ProductsRepository productsRepository) {
        this.tablesRepository = tablesRepository;
        this.orderRepository = orderRepository;
        this.productsRepository = productsRepository;
    }


    @Override
    public Optional<Tables> findById(Long number) {
        return tablesRepository.findById(number);
    }

    @Override
    public List<Tables> findAll() {
        return tablesRepository.findAll();
    }

    @Override
    public List<Order> listAllOrdersInTable(Long number) {
        if(!this.tablesRepository.findById(number).isPresent())
            throw new TableNotFoundException(number);
        return this.tablesRepository.findById(number).get().getOrders();

    }

    @Override
    public Boolean addOrderInTable(Long number, Long productId) {
        if(!this.tablesRepository.findById(number).isPresent())
            throw new TableNotFoundException(number);

        Optional<Tables> table = this.tablesRepository.findById(number);


        Products product = this.productsRepository.findById(productId).get();

        Order order = new Order(product);
        this.orderRepository.saveAndFlush(order);

        List<Order> orders = table.get().getOrders();


         orders.add(order);
         this.productsRepository.saveAndFlush(product);
         return true;
    }


}
