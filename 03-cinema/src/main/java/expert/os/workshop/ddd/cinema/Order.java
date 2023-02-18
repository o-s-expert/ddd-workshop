package expert.os.workshop.ddd.cinema;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Order {

    private Moviegoer moviegoer;

    private Order(Moviegoer moviegoer) {
        this.moviegoer = moviegoer;
    }

    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        Objects.requireNonNull(product,"product is required");
        this.products.add(product);
    }

    public Moviegoer getMoviegoer() {
        return moviegoer;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(moviegoer, order.moviegoer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(moviegoer);
    }

    public static Order of(Moviegoer moviegoer) {
        Objects.requireNonNull(moviegoer, "moviegoer is required");
        return new Order(moviegoer);
    }
}
