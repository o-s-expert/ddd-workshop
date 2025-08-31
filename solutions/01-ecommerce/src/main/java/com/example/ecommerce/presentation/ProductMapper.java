package com.example.ecommerce.presentation;

import com.example.ecommerce.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ProductMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "price.currency", source = "dto.currency")
    @Mapping(target = "price.amount", source = "dto.amount")
    Product toDomain(ProductRequest dto);

    @Mapping(target = "currency", source = "price.currency")
    @Mapping(target = "amount", source = "price.amount")
    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> products);
}