package tests;

public class Cerradura {
	private int clave;
	private boolean cerrada;
	private int intentosFallidos = 0;
	private int maximosFallos;
	private boolean bloqueada = false;

	public Cerradura(int i, int j) {
		this.clave = i;
		this.maximosFallos = j;
		cerrada = true;
	}

	public boolean abrir(int i) {
		if (bloqueada) {
			return false;
		}
		if (i == clave) {
			intentosFallidos = 0;
			cerrada = false;
			return true;
		} else {
			intentosFallidos ++;
			if (intentosFallidos >= maximosFallos) {
				bloqueada  = true;
			}
			cerrada = true;
			return false;
		}
		
	}

	public boolean isCerrada() {
		return cerrada;
	}

	public void cerrar() {
		cerrada = true;
		
	}

	public boolean isBloqueada() {
		return bloqueada;
	}
	

}
