package tragamonedas;

public class TamborDePrueba implements Tambor {
	private int valorPrueba;

	public TamborDePrueba(int valorPrueba) {
		this.valorPrueba = valorPrueba;
	}


	public int girar() {
		
		return valorPrueba;
	}


	public int valor() {
		return valorPrueba;
	}

}
