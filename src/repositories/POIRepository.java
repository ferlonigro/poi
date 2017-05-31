package repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.POI;

public class POIRepository {
	private static String POIsPath = "C:\\devel\\pois.txt";
	private Gson gson = new GsonBuilder().create();
	
	Set<POI> result = new HashSet<>();
	public POI[] getPois(String servicio) throws IOException {
		byte[] jsonBytes = Files.readAllBytes(Paths.get(POIsPath));
		String json = new String(jsonBytes);
		
		POI[] pois = gson.fromJson(json, POI[].class);
		
		for (POI poi : pois) {
			if (poi.getServicio().equalsIgnoreCase(servicio)) {
				result.add(poi);
			}
		}
		
		return result.toArray(new POI[result.size()]);
	}
}
