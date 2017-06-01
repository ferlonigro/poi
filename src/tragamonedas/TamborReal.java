package tragamonedas;

import java.util.Random;

public class TamborReal implements Tambor {
	int valor;
	@Override
	public int girar() {
		
		Random r = new Random();
		
		valor = r.nextInt(7) + 1;
		
		return valor;
	}

	@Override
	public int valor() {
		return valor;
	}

}
