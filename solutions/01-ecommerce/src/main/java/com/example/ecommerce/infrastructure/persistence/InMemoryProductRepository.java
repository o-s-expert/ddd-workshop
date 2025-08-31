package com.example.ecommerce.infrastructure.persistence;



import com.example.ecommerce.annotations.Repository;
import com.example.ecommerce.domain.Product;
import com.example.ecommerce.domain.ProductRepository;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> store = new HashMap<>();

    @Override
    public void save(Product product) {
        store.put(product.getId(), product);
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
    public void delete(String id) {
        store.remove(id);
    }
}