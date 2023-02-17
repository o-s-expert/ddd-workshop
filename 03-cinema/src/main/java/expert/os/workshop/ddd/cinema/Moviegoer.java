package expert.os.workshop.ddd.cinema;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.util.Objects;

@Entity
public class Moviegoer {

    @Identity
    private String id;

    private String name;

    public Moviegoer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Moviegoer moviegoer = (Moviegoer) o;
        return Objects.equals(id, moviegoer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Moviegoer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
