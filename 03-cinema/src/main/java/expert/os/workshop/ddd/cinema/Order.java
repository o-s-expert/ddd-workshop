package expert.os.workshop.ddd.cinema;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Order {

    @Identity
    private String id;
    private Moviegoer moviegoer;

    private List<Product> products = new ArrayList<>();

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
}
