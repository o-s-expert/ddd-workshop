package expert.os.workshop.ddd.cinema;

import org.jmolecules.ddd.annotation.ValueObject;

import java.time.Year;


@ValueObject
public record Movie(String title, Year year) {
}
