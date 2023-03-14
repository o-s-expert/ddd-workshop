package expert.os.workshop.ddd.microstream.microservices;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.Objects;

@Entity
@JsonbVisibility(PrivateVisibilityStrategy.class)
public record Book(@Id String isbn, @Column("title") String title, @Column("year") int year) {


    @JsonbCreator
    public static Book create(@JsonbProperty("isbn") String isbn, @JsonbProperty("title") String title, @JsonbProperty("year") int year) {
        return new Book(isbn, title, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

}
