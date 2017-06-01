package tragamonedas;

import java.util.Random;

public class TamborReal implements Tambor {
	int valor;

	public int girar() {
		
		Random r = new Random();
		
		valor = r.nextInt(7) + 1;
		
		return valor;
	}

	public int valor() {
		return valor;
	}

}
