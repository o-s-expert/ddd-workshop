package com.example.ecommerce.domain;

import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository {

    @Save
    Product save(Product product);
    Optional<Product> findById(String id);
    List<Product> findAll();


    void deleteById(String id);

}
