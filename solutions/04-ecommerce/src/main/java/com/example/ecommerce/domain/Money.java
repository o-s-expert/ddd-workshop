package com.example.ecommerce.domain;

import jakarta.nosql.Column;
import jakarta.nosql.Embeddable;
import org.jmolecules.ddd.annotation.ValueObject;

import java.math.BigDecimal;

@Embeddable(Embeddable.EmbeddableType.GROUPING)
@ValueObject
public record Money(@Column String currency, @Column BigDecimal amount) {
}
