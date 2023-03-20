package expert.os.workshop.ddd.jnosql;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface Library extends CrudRepository<Book, String> {
    void deleteByTitle(String title);

    List<Book> findByTitle(String title);
}
