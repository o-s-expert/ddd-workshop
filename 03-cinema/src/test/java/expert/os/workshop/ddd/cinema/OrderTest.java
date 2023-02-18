package expert.os.workshop.ddd.cinema;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
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
        Movie movie = new Movie("Matriz", Year.of(1999));
        Product ticket = new Ticket(movie, Money.of(10, currency));
        Product popcorn = new Food("popcorn", Money.of(15, currency));
        Order order = Order.of(moviegoer);

    }


}