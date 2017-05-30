package domain;

import java.util.ArrayList;
import java.util.List;

public class Itinerario {
	private long id;
	private String nombre;
	private ArrayList<POI> pois;
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<POI> getPois() {
		return pois;
	}
}
