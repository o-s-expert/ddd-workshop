package com.example.ecommerce.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);
    Optional<Product> findById(String id);
    List<Product> findAll();
    void delete(String id);

}
