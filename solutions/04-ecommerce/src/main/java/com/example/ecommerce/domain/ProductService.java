package com.example.ecommerce.domain;

import com.example.ecommerce.annotations.ApplicationService;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ApplicationService
public class ProductService {

    private final ProductRepository productRepository;

    private final UpdateProductPrice updateProductPrice;

    @Inject
    public ProductService(ProductRepository productRepository, UpdateProductPrice updateProductPrice) {
        this.productRepository = productRepository;
        this.updateProductPrice = updateProductPrice;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void changePrice(String id, BigDecimal price) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id " + id + " not found"));
        //we could improve this exception as well.
        this.updateProductPrice.execute(product, price);
    }
}
