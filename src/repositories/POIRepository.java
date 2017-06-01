package repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.POI;

public class POIRepository {
	private static String POIsPath = "pois.txt";
	private static Gson gson = new GsonBuilder().create();
	private static POI[] pois;
	static {
		try {
			load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Set<POI> result = new HashSet<POI>();
	public POI[] getPois(String servicio) {
		for (POI poi : pois) {
			if (poi.getServicio().equalsIgnoreCase(servicio)) {
				result.add(poi);
			}
		}
		
		if (result.isEmpty()) {
			return null;
		} else {
			return result.toArray(new POI[result.size()]);
		}
		
	}
	
	private static void load() throws IOException {
		byte[] jsonBytes = Files.readAllBytes(Paths.get(POIsPath));
		String json = new String(jsonBytes);
		
		pois = gson.fromJson(json, POI[].class);
	}
}
