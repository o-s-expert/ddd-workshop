package expert.os.workshop.ddd.microstream.microservices;

import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Repository;

@Repository
public interface Library extends PageableRepository<Book, String> {
}
