package com.example.ecommerce.domain;

import jakarta.nosql.Column;
import jakarta.nosql.Embeddable;

import java.math.BigDecimal;

@Embeddable(Embeddable.EmbeddableType.GROUPING)
public record Money(@Column String currency, @Column BigDecimal amount) {
}
