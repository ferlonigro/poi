package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.POI;

@Path("/")
public class Test {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public POI[] getTrackInJSON() {
		POI[] pois = new POI[2];
		

		pois[0] = new POI("servicio", 1, "nombre 1", "descripcion 1", -32, -64);
		pois[1] = new POI("servicio", 2, "nombre 2", "descripcion 2", -32, -64);

		return pois;
	}
}
