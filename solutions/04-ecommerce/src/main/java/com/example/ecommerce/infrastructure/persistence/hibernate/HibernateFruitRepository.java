package com.example.ecommerce.infrastructure.persistence.hibernate;

import com.example.ecommerce.domain.Fruit;
import com.example.ecommerce.domain.FruitRepository;

import java.util.List;

public class HibernateFruitRepository implements FruitRepository {


    @Override
    public List<Fruit> findAll() {
        return List.of(new FruitHibernate());
    }
}
