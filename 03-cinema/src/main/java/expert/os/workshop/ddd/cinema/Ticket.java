package expert.os.workshop.ddd.cinema;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import javax.money.MonetaryAmount;

@Entity
public class Ticket implements Product {

    @Identity
    private String id;

    private Movie movie;

    private MonetaryAmount price;

    @Override
    public MonetaryAmount price() {
        return price;
    }
}
