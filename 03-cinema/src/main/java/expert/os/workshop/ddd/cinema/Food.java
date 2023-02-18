package expert.os.workshop.ddd.cinema;

import javax.money.MonetaryAmount;

public record Food (String name, MonetaryAmount price) implements Product {

}
