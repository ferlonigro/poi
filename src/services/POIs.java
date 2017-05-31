package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Mapa;
import domain.POI;
import repositories.MapaRepository;
import repositories.POIRepository;

@Path("/")
public class POIs {
	@GET
	@Path("/pois/{servicio}")
	@Produces(MediaType.APPLICATION_JSON)
	public POI[] getTrackInJSON(@PathParam("servicio") String servicio) {

		POIRepository repo = new POIRepository();
		
		POI[] pois = null;

		pois = repo.getPois(servicio);


		return pois;
	}
	
	
	@GET
	@Path("/mapa/{servicio}/{mapa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Mapa[] getMap(@PathParam("servicio") String servicio, @PathParam("mapa") String mapa) {

		MapaRepository repo = new MapaRepository();
		
		Mapa[] mapas = null;

		mapas = repo.getMapa(servicio, mapa);


		return mapas;
	}
}
