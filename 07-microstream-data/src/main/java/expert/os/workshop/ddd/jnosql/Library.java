package expert.os.workshop.ddd.jnosql;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface Library extends CrudRepository<Book, String> {
}
