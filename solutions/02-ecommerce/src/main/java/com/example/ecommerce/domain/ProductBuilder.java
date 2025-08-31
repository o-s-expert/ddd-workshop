package com.example.ecommerce.domain;

public class ProductBuilder {
    private String id;
    private String name;
    private Money price;

    public ProductBuilder id(String id) {
        this.id = id;
        return this;
    }

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder price(Money price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(id, name, price);
    }
}