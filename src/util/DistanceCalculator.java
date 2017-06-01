package util;
public class DistanceCalculator {

	
	/**
	 * Calcula la distancia de dos puntos georreferenciados.
	 * 
	 * @param latitud1
	 * @param longitud1
	 * @param latitud2
	 * @param longitud2
	 * @return
	 */
	public static float getDistance(double latitud1, double longitud1, double latitud2, double longitud2) {

		final int R = 6371000; // Radio de la tierra en metros
		double dLat = Math.toRadians(Math.abs(latitud2 - latitud1));
		double dLong = Math.toRadians(Math.abs(longitud2 - longitud1));
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(Math.toRadians(latitud1)) * Math.cos(Math.toRadians(latitud2)) * Math.sin(dLong / 2) * Math.sin(dLong / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		float dist = (float) (R * c);

		return dist;
	}
}
