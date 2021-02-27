package nl.han.dea.services.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ItemNotAvailableMapper implements ExceptionMapper<ItemNotAvailableException> {
    public Response toResponse(ItemNotAvailableException e) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
