package com.example.ecommerce;

import java.math.BigDecimal;

public record Money(String currency, BigDecimal amount) {
}
