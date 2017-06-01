package services;

import domain.POI;
import repositories.POIRepository;
import util.DistanceCalculator;

public class POIMasCercanoService {

	public POI getPoisMasCercano (String servicio, double latitud, double longitud) {
		POIRepository repo = new POIRepository();
		
		POI[] pois = repo.getPois(servicio);
		POI poiMasCercano = null;
		if (pois==null) {
			return null;
		} else {

			boolean inicializado = false;
			float distancia = 0;
			
			for (POI actual:pois) {
				if (!inicializado) {
					distancia = DistanceCalculator.getDistance(latitud, longitud, actual.getLatitud(), actual.getLongitud());
					poiMasCercano = actual;
					inicializado = true;
				}
				
				float nuevaDistancia = DistanceCalculator.getDistance(latitud, longitud, actual.getLatitud(), actual.getLongitud());
				
				if (nuevaDistancia < distancia) {
					distancia = nuevaDistancia;
					poiMasCercano = actual;
				}
			}
		}
		
		return poiMasCercano;
	}
	
}
