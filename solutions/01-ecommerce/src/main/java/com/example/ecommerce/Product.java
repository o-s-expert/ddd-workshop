package com.example.ecommerce;


import com.example.ecommerce.infrastructure.AllFieldsVisibilityStrategy;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbVisibility;

import java.util.Objects;

@JsonbVisibility(AllFieldsVisibilityStrategy.class)
public class Product {

    private String id;
    private String name;
    private Money price;



    @JsonbCreator
    public static Product of(@JsonbProperty("id") String id,
                             @JsonbProperty("name") String name,
                             @JsonbProperty("price") Money price) {
        Product product = new Product();
        product.id = id;
        product.name = name;
        product.price = price;
        return product;
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
}
