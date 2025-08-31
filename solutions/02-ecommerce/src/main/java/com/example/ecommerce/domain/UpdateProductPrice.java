package com.example.ecommerce.domain;

import com.example.ecommerce.annotations.DomainService;
import com.example.ecommerce.domain.events.ProductPriceChanged;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.Objects;

@DomainService
public class UpdateProductPrice {

    private final ProductRepository repository;

    private final Event<ProductPriceChanged> productPriceChangedEvent;


    @Inject
    public UpdateProductPrice(ProductRepository repository, Event<ProductPriceChanged> productPriceChangedEvent) {
        this.repository = repository;
        this.productPriceChangedEvent = productPriceChangedEvent;
    }

    public void execute(Product product, BigDecimal price) {
        Objects.requireNonNull(product, "Product must not be null.");
        Objects.requireNonNull(price, "Price must not be null.");
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be > 0.");
        }
        var event = new ProductPriceChanged(product.getId(), product.getPrice().amount(), price);
        this.productPriceChangedEvent.fire(event);
        product.update(price);
        this.repository.save(product);
    }
}
