package expert.os.workshop.ddd.cinema;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

public class Food implements Product{

    private String name;

    private MonetaryAmount price;

    @Override
    public MonetaryAmount price() {
        return price;
    }
}
