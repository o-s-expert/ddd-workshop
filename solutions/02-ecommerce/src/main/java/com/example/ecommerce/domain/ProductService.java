package com.example.ecommerce.domain;

import com.example.ecommerce.annotations.ApplicationService;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ApplicationService
public class ProductService {

    private final ProductRepository repository;

    private final UpdateProductPrice updateProductPrice;

    @Inject
    public ProductService(ProductRepository repository, UpdateProductPrice updateProductPrice) {
        this.repository = repository;
        this.updateProductPrice = updateProductPrice;
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

    public void changePrice(String id, BigDecimal price) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " not found"));
        //we could improve this exception as well.
        this.updateProductPrice.execute(product, price);
    }
}
