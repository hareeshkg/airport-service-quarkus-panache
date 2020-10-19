package com.hkg.quarkus.airport.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.ok;

import java.util.List;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.hkg.quarkus.airport.entity.Airport;
import com.hkg.quarkus.airport.service.AirportService;

@Path("/airport")
public class AirportController {

	@Inject
	AirportService airporService;


	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> getAllAirports() {
		return this.airporService.getAllAirports();
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Airport save(Airport airport) {
		return this.airporService.save(airport);
	}

	@DELETE
	@Path("/delete/{id}/")
	public Response deleteOrderById(@PathParam("id") Long id) {

		try {
			this.airporService.deleteByid(id);
		} catch (Exception e) {
			return Response.status(Response.Status.OK).entity("Delete failed").build();
		}
		return Response.status(Response.Status.OK).entity("Deleted successfully").build();
	}
}