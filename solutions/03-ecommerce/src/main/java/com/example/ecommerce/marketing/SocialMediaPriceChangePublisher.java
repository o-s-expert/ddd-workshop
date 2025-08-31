package com.example.ecommerce.marketing;


import com.example.ecommerce.domain.events.ProductPriceChanged;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.math.BigDecimal;

@ApplicationScoped
public class SocialMediaPriceChangePublisher {

    public void onPriceChange(@Observes ProductPriceChanged event) {
        BigDecimal oldP = event.oldPrice();
        BigDecimal newP = event.newPrice();

        // demo behavior: print only when the price dropped
        if (newP.compareTo(oldP) < 0) {
            System.out.println("[SOCIAL] 🎉 Promo! Product " + event.productId()
                    + " dropped from " + oldP + " to " + newP + ". #Sale #Deal");
        } else {
            // keep it simple for the lab—no op on increases
            System.out.println("[SOCIAL] (ignored) price increased for " + event.productId()
                    + " from " + oldP + " to " + newP);
        }
    }
}