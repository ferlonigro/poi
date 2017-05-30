package domain;

public class Servicio {
	private long id;
	private String nombre;
	
	public Servicio(long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	

}
