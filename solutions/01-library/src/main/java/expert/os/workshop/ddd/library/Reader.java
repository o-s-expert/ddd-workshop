package expert.os.workshop.ddd.library;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Reader {


    @Identity
    private String name;

    private List<Book> books = new ArrayList<>();

    public Reader(String name) {
        this.name = name;
    }

    public void checkout(Order order) {
        Objects.requireNonNull(order, "order is required");
        this.books.addAll(order.getBooks());
    }


    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reader reader = (Reader) o;
        return Objects.equals(name, reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
