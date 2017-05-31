package domain;

import java.util.Set;

public class Mapa {
	private String servicio;
	private long id;
	private String nombre;
	private Set<POI> pois;

	public Mapa(String servicio, long id, String nombre, Set<POI> pois) {
		this.servicio = servicio;
		this.id = id;
		this.nombre = nombre;
		this.pois = pois;
	}

	public String getServicio() {
		return servicio;
	}

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
