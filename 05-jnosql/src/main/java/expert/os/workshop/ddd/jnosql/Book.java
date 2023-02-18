package expert.os.workshop.ddd.jnosql;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.Year;

@Entity
public record Book(@Id String isbn, @Column("title") String title, @Column("year") Year year) {
}
