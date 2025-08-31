package com.example.ecommerce.domain;


import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String id;
    private String name;
    private Money price;


    Product(String id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public void update(BigDecimal amount) {
        this.price = new Money(price.currency(), amount);
    }
}
