package expert.os.workshop.ddd.cinema;

import org.jmolecules.ddd.annotation.Entity;

import javax.money.MonetaryAmount;

@Entity
public record Ticket (String id, MonetaryAmount price, Movie movie) implements Product {

}
