package expert.os.workshop.ddd.cinema;

import org.assertj.core.api.Assertions;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.time.Year;
import java.util.Locale;

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
        Movie movie = new Movie("Matrix", Year.of(1999));
        Product ticket = new Ticket(movie, Money.of(10, currency));
        Product popcorn = new Food("popcorn", Money.of(15, currency));
        Order order = Order.of(moviegoer);

        order.add(ticket);
        order.add(popcorn);

        MonetaryAmount total = order.total();
        Assertions.assertThat(total)
                .isEqualTo(Money.of(25, currency));
    }


}