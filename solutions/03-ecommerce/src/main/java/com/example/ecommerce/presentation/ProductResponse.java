package com.example.ecommerce.presentation;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String currency, BigDecimal amount) {
}
