package domain;

public class POI {
	private String servicio;
	private long id;
	private String nombre;
	private String descripcion;
	private double latitud;
	private double longitud;
	
	public POI(String servicio, long id, String nombre, String descripcion, long latitud, long longitud) {
		this.servicio = servicio;
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
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
	
	public String getDescripcion() {
		return descripcion;
	}

	public double getLatitud() {
		return latitud;
	}
	
	public double getLongitud() {
		return longitud;
	} 
}
