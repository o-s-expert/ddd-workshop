package expert.os.workshop.ddd.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Order {

    private Reader reader;

    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void add(Book book) {
        Objects.requireNonNull(book, "book is required");
        this.books.add(book);
    }


}
