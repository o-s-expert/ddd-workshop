package expert.os.workshop.ddd.library;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.time.Year;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class OrderTest {

    @Mock
    private Books books;

    private CurrencyUnit usd;

    @BeforeEach
    public void setUp() {
        this.usd = Monetary.getCurrency(Locale.US);
        Book effectiveJava =
                Book.builder().isbn("234")
                        .author("Joshua").title("Effective Java")
                        .year(Year.of(2015))
                        .price(Money.of(1, usd))
                        .build();

        Mockito.when(books.search()).thenReturn(List.of(effectiveJava));
    }

    @Test
    public void shouldBuyBook() {

    }
}