package services;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.POI;
import repositories.POIRepository;

@Path("/")
public class POIs {
	@GET
	@Path("/pois/{servicio}")
	@Produces(MediaType.APPLICATION_JSON)
	public POI[] getTrackInJSON(@PathParam("servicio") String servicio) {

		POIRepository repo = new POIRepository();
		
		POI[] pois = null;
		try {
			pois = repo.getPois(servicio);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pois;
	}
}
