package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(@Lazy ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create or Update
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Read All
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Read by ID
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // Delete
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }
}
