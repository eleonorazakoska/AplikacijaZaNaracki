package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tables {

    @Id
    private Long number;

    @OneToMany
    private List<Order> orders;


    public Tables(Long number, List<Order> orders) {
        this.number = number;
        this.orders=orders;

    }

    public Tables() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
