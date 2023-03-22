package expert.os.workshop.ddd.cinema;

import javax.money.MonetaryAmount;

public record Beverage (String name, MonetaryAmount price)  implements Product { }
