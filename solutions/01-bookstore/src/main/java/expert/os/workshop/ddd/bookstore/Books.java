package expert.os.workshop.ddd.bookstore;

import org.jmolecules.ddd.annotation.Repository;

import java.util.List;

@Repository
public interface Books {

    List<Book> search();
}
