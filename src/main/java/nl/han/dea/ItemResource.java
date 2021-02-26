package nl.han.dea;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/items")
public class ItemResource {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response items() {
        return Response.ok("bread, butter").build();
    }
}
