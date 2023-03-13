package expert.os.workshop.ddd.jnosql;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.Year;
import java.util.Objects;

@Entity
public class Book {
    @Id
    private  String isbn;
    @Column("title")
    private String title;
    @Column("year")
    private Year year;

    public Book(String isbn, String title, Year year) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
    }


    public String isbn() {
        return isbn;
    }

    public String title() {
        return title;
    }

    public Year year() {
        return year;
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

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
