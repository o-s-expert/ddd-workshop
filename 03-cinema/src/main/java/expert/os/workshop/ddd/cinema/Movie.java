package expert.os.workshop.ddd.cinema;

import org.jmolecules.ddd.annotation.Entity;

import java.time.Year;


@Entity
public record Movie(String title, Year year) {
}
