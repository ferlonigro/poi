package tragamonedas;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class TragamonedasTest {
	@Test
	public void tamborSeDetieneEntre1y8() {
		Tambor tambor = new TamborReal();
		
		for (int i = 1; i<10; i++)
			assertThat(tambor.girar()).isBetween(1, 8);
	}
	
	@Test
	public void elTamborGira() {
		
		Tragamonedas tragamonedas = new Tragamonedas (new TamborReal(), new TamborReal(), new TamborReal());
		
		tragamonedas.activar();
		
		
		
		assertThat(tragamonedas.getValor1()).isBetween(1, 8);
		assertThat(tragamonedas.getValor2()).isBetween(1, 8);
		assertThat(tragamonedas.getValor3()).isBetween(1, 8);
		
				
	
	}
	


	@Test
	public void elTragamonedasEntregaPremio() {
		Tragamonedas tragamonedas = new Tragamonedas(new TamborDePrueba(3), new TamborDePrueba(3), new TamborDePrueba(3));
		tragamonedas.activar();
		assertThat(tragamonedas.entregaPremio()).isEqualTo(true);
	}
	
	@Test
	public void elTragamonedasNoEntregaPremio() {
		Tragamonedas tragamonedas = new Tragamonedas(new TamborDePrueba(3), new TamborDePrueba(1), new TamborDePrueba(5));
		tragamonedas.activar();
		assertThat(tragamonedas.entregaPremio()).isEqualTo(false);
	}
}
