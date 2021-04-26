package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "naracka")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @OneToOne
    private Products product;



    public Order() {

    }

    public Order( Products product) {
        this.product = product;

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }


}

