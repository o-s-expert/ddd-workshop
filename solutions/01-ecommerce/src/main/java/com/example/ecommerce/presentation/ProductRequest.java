package com.example.ecommerce.presentation;

import java.math.BigDecimal;

public record ProductRequest(String name, String currency, BigDecimal amount) {
}
