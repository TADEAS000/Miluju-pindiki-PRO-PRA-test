package cz.spsmb.rest;

import cz.spsmb.dao.GarageRepository;
import cz.spsmb.model.Garage;
import cz.spsmb.model.Person;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import cz.spsmb.dao.PersonRepository;

import java.util.List;

@Path("/garages")
public class GarageResource {

    @Inject
    GarageRepository garageRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response list() {
        List<Garage> garages = garageRepository.listAll();
        return Response.ok().entity(garages).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Garage garage = garageRepository.findById(id);
        return Response.ok().entity(garage).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteById(@PathParam("id") Long id) {
        garageRepository.deleteById(id);
        return Response.ok().entity("ok").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response save(Garage garage) {
        garage.setId(0l);
        if (garage.getUlice() != null && garage.getCisloPopisne() > 0) {
            garageRepository.persist(garage);
            return Response.ok().entity("ok").build();
        } else {
            return Response.status(400).entity("Person must have attributes.").build();
        }

    }


}