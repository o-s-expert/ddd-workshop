package com.example.ecommerce.domain;

import java.math.BigDecimal;

public record Money(String currency, BigDecimal amount) {
}
