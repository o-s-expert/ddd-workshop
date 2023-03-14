package expert.os.workshop.ddd.microstream.microservices;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/library")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LibraryResource {

    @Inject
    private Library library;


    @GET
    public List<Book> findAll() {
        return this.library.findAll().collect(Collectors.toUnmodifiableList());
    }

    @GET
    @Path("{id}")
    public Book findById(@PathParam("id") String id) {
        Optional<Book> book = this.library.findById(id);
        return book.orElseThrow(() -> new WebApplicationException(NOT_FOUND));
    }

    @PUT
    public void save(Book book) {
        this.library.save(book);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        this.delete(id);
    }
}
