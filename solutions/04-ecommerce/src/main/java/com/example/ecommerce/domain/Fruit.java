package com.example.ecommerce.domain;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public interface Fruit {

    @Identity
    UUID getId();

    String getName();

    Money getPrice();

    void update(Money amount);

    boolean isvalid();



}
