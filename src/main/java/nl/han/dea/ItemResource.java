package nl.han.dea;

import nl.han.dea.services.ItemService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/items")
public class ItemResource {

    private ItemService itemService;

    public ItemResource() {
        this.itemService = new ItemService();
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getItemsPlain() {
        return Response.ok("bread, butter").build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemsJson() {
        return Response.status(Response.Status.OK)
                .entity(itemService.getAll())
                .build();
    }

    @GET
    @Path("/{itemID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemById(@PathParam("itemID") Integer itemID) {
        return Response.status(Response.Status.OK)
                .entity(itemService.getItem(itemID))
                .build();
    }
}
