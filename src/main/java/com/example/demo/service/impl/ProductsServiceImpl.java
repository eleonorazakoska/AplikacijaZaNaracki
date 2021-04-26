package com.example.demo.service.impl;

import com.example.demo.model.Products;
import com.example.demo.model.exceptions.ProductNotFoundException;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Optional<Products> findById(Long productId) {
        return this.productsRepository.findById(productId);
    }

    @Override
    public List<Products> findAll() {
        return this.productsRepository.findAll();
    }


    @Override
    public void deleteById(Long productId)
    {
        this.productsRepository.deleteById(productId);
    }

    @Override
    public Optional<Products> save(String productName, Float price, Long productId) {

       // this.productsRepository.deleteById(productId);
        return Optional.of(this.productsRepository.save
                (new Products(productName, price, productId)));
    }

    @Override
    public Optional<Products> edit(String productName, Float price, Long productId) {
        Products product = this.productsRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductid(productId);
        return Optional.of(this.productsRepository.save(product));

    }
}
