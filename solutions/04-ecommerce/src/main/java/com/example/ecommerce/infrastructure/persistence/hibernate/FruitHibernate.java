package com.example.ecommerce.infrastructure.persistence.hibernate;

import com.example.ecommerce.domain.Fruit;
import com.example.ecommerce.domain.Money;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.util.UUID;

@Entity
public class FruitHibernate implements Fruit {

    private UUID id;

    private String name;

    private Money price;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money getPrice() {
        return price;
    }

    @Override
    public void update(Money amount) {
        this.price = amount;
    }

    @Override
    public boolean isvalid() {
        return false;
    }
}
