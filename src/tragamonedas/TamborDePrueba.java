package tragamonedas;

public class TamborDePrueba implements Tambor {
	private int valorPrueba;

	public TamborDePrueba(int valorPrueba) {
		this.valorPrueba = valorPrueba;
	}


	@Override
	public int girar() {
		
		return valorPrueba;
	}


	@Override
	public int valor() {
		return valorPrueba;
	}

}
