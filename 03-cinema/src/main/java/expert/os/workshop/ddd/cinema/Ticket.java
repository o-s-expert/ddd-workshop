package expert.os.workshop.ddd.cinema;

import javax.money.MonetaryAmount;

public class Ticket implements Product {

    private Movie movie;
    @Override
    public MonetaryAmount price() {
        return null;
    }
}
