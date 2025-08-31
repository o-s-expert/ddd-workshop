package com.example.ecommerce.domain.events;

import java.math.BigDecimal;

public record ProductPriceChanged(String productId, BigDecimal oldPrice, BigDecimal newPrice) {
}
