package domain;

import java.util.HashSet;
import java.util.Set;

public class Mapa {
	private long id;
	private String nombre;
	private HashSet<POI> pois;
	
	public long getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Set<POI> getPois() {
		return pois;
	}
}
