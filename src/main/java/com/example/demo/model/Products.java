package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

    private String productName;
    private Float price;
    @Id
    private Long productId;

    public Products(String productName, Float price, Long productId) {
        this.productName = productName;
        this.price = price;
        this.productId = productId;
    }

    public Products() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productname) {
        this.productName = productname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductid(Long productid) {
        this.productId = productId;
    }
}
