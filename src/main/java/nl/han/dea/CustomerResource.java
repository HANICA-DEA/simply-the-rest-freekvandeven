package nl.han.dea;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers")
public class CustomerResource {


    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllCustomersAsText() {
        return Response.ok("Uwe,Freek").build();
    }

}
