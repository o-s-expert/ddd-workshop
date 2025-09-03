package com.example.ecommerce.domain;

import com.example.ecommerce.annotations.ApplicationService;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationService
public class ProductService {

    private final ProductRepository repository;

    @Inject
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Optional<Product> findById(String id) {
        return repository.findById(id);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }
}
