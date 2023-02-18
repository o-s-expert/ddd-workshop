package expert.os.workshop.ddd.cinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Moviegoer moviegoer;

    private CurrencyUnit currency;

    @BeforeEach
    public void setUp() {
        this.moviegoer = new Moviegoer("id", "Ada");
        this.currency = Monetary.getCurrency(Locale.US);
    }

    @Test
    public void shouldTotal() {
        Product ticket = new Ticket();
    }


}