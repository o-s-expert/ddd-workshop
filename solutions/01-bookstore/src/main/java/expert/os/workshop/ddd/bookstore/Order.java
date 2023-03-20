package expert.os.workshop.ddd.bookstore;

import org.javamoney.moneta.Money;
import org.jmolecules.ddd.annotation.Entity;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Entity
public class Order {

    private static final CurrencyUnit USD = Monetary.getCurrency(Locale.US);

    private final Reader reader;

    private List<Book> books = new ArrayList<>();

    private Order(Reader reader) {
        this.reader = reader;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void add(Book book) {
        Objects.requireNonNull(book, "book is required");
        this.books.add(book);
    }

    public MonetaryAmount total() {
       return this.books.stream().map(Book::getPrice)
                .reduce(MonetaryAmount::add)
                .orElse(Money.of(0, USD));
    }

    public static Order of(Reader reader) {
        Objects.requireNonNull(reader, "reader is required");
        return new Order(reader);
    }
}
