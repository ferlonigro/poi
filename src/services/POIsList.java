package services;

import domain.POI;

public class POIsList {
	private int codError;
	private String descripcionError;
	
	private POI[] resultado;

	
	public POIsList(int codError, String descripcionError, POI[] resultado) {
		this.codError = codError;
		this.descripcionError = descripcionError;
		this.resultado = resultado;
	}

	public int getCodError() {
		return codError;
	}

	public String getDescripcionError() {
		return descripcionError;
	}

	public POI[] getResultado() {
		return resultado;
	}
	
	

}
