package expert.os.workshop.ddd.cinema;

import javax.money.MonetaryAmount;
import java.util.Objects;

public class Food implements Product {

    private String name;

    private MonetaryAmount price;

    public String getName() {
        return name;
    }

    @Override
    public MonetaryAmount price() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
