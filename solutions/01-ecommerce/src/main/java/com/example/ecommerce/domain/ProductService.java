package com.example.ecommerce.domain;

import com.example.ecommerce.annotations.ApplicationService;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationService
public class ProductService {

    private final ProductRepository productRepository;

    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.delete(id);
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
