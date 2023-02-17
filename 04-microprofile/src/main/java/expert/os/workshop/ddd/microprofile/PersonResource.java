package expert.os.workshop.ddd.microprofile;


import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Path("people")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static final Logger LOGGER = Logger.getLogger(PersonResource.class.getName());
    @GET
    public List<Person> getPerson() {
        LOGGER.warning("Get list");
        return List.of(new Person("Otavio", "Salvador"));
    }

    @POST
    public void insert(Person person) {
        LOGGER.warning("Insert: " + person);
    }

    @Path("{id}")
    public void delete(@PathParam("id") String id){
        LOGGER.warning("delete: " + id);
    }

    @Path("{id}")
    public void update(@PathParam("id") String id, Person person){
        LOGGER.warning("update: " + person + " id " + id);
    }
}
