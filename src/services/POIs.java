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
	public POIsList getTrackInJSON(@PathParam("servicio") String servicio) {

		POIRepository repo = new POIRepository();
		
		POI[] pois = null;

		pois = repo.getPois(servicio);

		POIsList list;
		if (pois==null) {
			list = new POIsList(1, "El servicio no existe", null);
		} else {
			list = new POIsList(0, null, pois);
		}
		

		return list;
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
	
	@GET
	@Path("/poismascercano/{servicio}/{latitud}/{longitud}")
	@Produces(MediaType.APPLICATION_JSON)
	public POIUnico getPoisMasCercano(@PathParam("servicio") String servicio, @PathParam("latitud") double latitud, @PathParam("longitud") double longitud) {

		
		POIMasCercanoService service = new POIMasCercanoService();
		
		POI poi = service.getPoisMasCercano(servicio, latitud, longitud);
		
		if (poi == null) {
			return new POIUnico(1, "No existe el servicio", null);
		} else {
			return new POIUnico(0, null, poi);
		}
		
	}
}
