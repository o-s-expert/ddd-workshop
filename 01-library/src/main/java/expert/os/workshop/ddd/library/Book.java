package expert.os.workshop.ddd.library;

import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import javax.money.MonetaryAmount;
import java.time.Year;

@Entity
public class Book {

    @Identity
    private String isbn;

    private String title;

    private String author;

    private Year year;

    private MonetaryAmount price;


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Year getYear() {
        return year;
    }

    public MonetaryAmount getPrice() {
        return price;
    }
}
