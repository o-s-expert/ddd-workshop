package expert.os.workshop.ddd.cinema;

import org.jmolecules.ddd.annotation.Entity;

import javax.money.MonetaryAmount;

@Entity
public record Ticket (Movie movie, MonetaryAmount price) implements Product { }
