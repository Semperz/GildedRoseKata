package edu.badpals.GildedRose;

import edu.badpals.GildedRose.domain.Item;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/")
public class ResourceGuilded {

    @Inject
    ServicesGuilded servicios;

    public ResourceGuilded(){}

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/wellcome")
    public String Wellcome() {
        return "Wellcome!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/item/{name}")
    public Response gItem(@PathParam("name") String nombre) {
        Item item = servicios.cargaItem(nombre);
        return (item.name.isEmpty() ?
                        Response.status(Response.Status.NOT_FOUND).build():
                        Response.status(Response.Status.OK).entity(item).build());
    }

    @POST
    @Path("/item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response cItem(@Valid Item itemPar) {
        Item item = servicios.crearItem(itemPar);
        return item.name.isEmpty()?
                Response.status(Response.Status.BAD_REQUEST).build():
                Response.status(Response.Status.CREATED).entity(item).build();
    }

    @GET
    @Path("/items/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(@PathParam("name") String nombre) {
        List<Item> items = servicios.cargaItems(nombre);
        return items.isEmpty() ?
            Response.status(Response.Status.NOT_FOUND).build() :
            Response.status(Response.Status.OK).entity(items).build();

    }

    @DELETE
    @Path("/item/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Item> deleteItem(@Valid Item itemPar) {
        servicios.deleteItem(itemPar);
        return servicios.cargaItems(itemPar.name);
    }
}
