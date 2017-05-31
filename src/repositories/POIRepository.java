package repositories;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.POI;

public class POIRepository {
	private Gson gson = new GsonBuilder().create();
	
	Set<POI> result = new HashSet<>();
	public POI[] getPois(String servicio) {
		
		POI[] pois = gson.fromJson("[{\"id\":1,\"latitud\":-32.0,\"longitud\":-64.0,\"nombre\":\"nombre 1\",\"descripcion\":\"descripcion 1\",\"servicio\":\"servicio\"},{\"id\":2,\"latitud\":-32.0,\"longitud\":-64.0,\"nombre\":\"nombre 2\",\"descripcion\":\"descripcion 2\",\"servicio\":\"servicio\"}]", POI[].class);
		
		for (POI poi : pois) {
			if (poi.getServicio().equalsIgnoreCase(servicio)) {
				result.add(poi);
			}
		}
		
		return result.toArray(new POI[result.size()]);
	}
}
