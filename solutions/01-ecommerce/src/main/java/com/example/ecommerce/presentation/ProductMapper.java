package com.example.ecommerce.presentation;

import com.example.ecommerce.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ProductMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Product toDomain(ProductRequest dto);

    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> products);
}