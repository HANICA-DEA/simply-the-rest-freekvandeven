package nl.han.dea;

import nl.han.dea.services.ItemService;
import nl.han.dea.services.dto.ItemDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/items")
public class ItemResource {

    private static ItemService itemService;

    public ItemResource() {
        if(itemService == null) {
            itemService = new ItemService();
        }
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

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postItem(ItemDTO item){
        itemService.addItem(item);
        return Response.status(Response.Status.CREATED).build();
    }
}
