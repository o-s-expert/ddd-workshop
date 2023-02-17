package expert.os.workshop.ddd.library;

import javax.money.MonetaryAmount;
import java.time.Year;

public class BookBuilder {
    private String isbn;
    private String title;
    private String author;
    private Year year;
    private MonetaryAmount price;

    BookBuilder() {
    }

    public BookBuilder isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder year(Year year) {
        this.year = year;
        return this;
    }

    public BookBuilder price(MonetaryAmount price) {
        this.price = price;
        return this;
    }

    public Book build() {
        return new Book(isbn, title, author, year, price);
    }
}