package com.example.ecommerce.infrastructure.persistence;



import com.example.ecommerce.domain.Product;
import com.example.ecommerce.domain.ProductRepository;
import java.util.*;

public class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> store = new HashMap<>();

    @Override
    public Product save(Product product) {
        store.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(String id) {
        store.remove(id);
    }
}