package tests;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CerraduraTest {
	private Cerradura cerradura = new Cerradura(223344, 2);
	

	@Test
	public void alCrearLaCerraduraDebeEstarCerrada() {
		assertThat(cerradura.isCerrada()).isEqualTo(true);
	}

	@Test
	public void alCrearLaCerraduraNoDebeEstarBloqueada() {
		assertThat(cerradura.isBloqueada()).isEqualTo(false);
	}
	
	@Test
	public void alCerrarDebeQuedarCerrada() {

		cerradura.abrir(223344);

		cerradura.cerrar();

		assertThat(cerradura.isCerrada()).isEqualTo(true);

	}

	@Test
	public void alAbrirDebeQuedarAbierta() {

		cerradura.abrir(223344);

		assertThat(cerradura.isCerrada()).isEqualTo(false);

	}

	@Test
	public void laCerraduraNoDebeAbrirConClaveInvalida() {

		boolean resultado = cerradura.abrir(12345);

		assertThat(resultado).isEqualTo(false);
	}

	@Test
	public void laCerraduraDebeAbrirConClaveCorrecta() {
		boolean resultado = cerradura.abrir(223344);

		assertThat(resultado).isEqualTo(true);
	}

	@Test
	public void laCerraduraSeBloqueaLuegoDesuperarCantidadDeIntentos() {
		
		cerradura.abrir(1234);
		cerradura.abrir(12345);
		cerradura.abrir(12);
		
		assertThat(cerradura.isBloqueada()).isEqualTo(true);
	}
	
	@Test
	public void laCerraduraNoSeBloqueaLuegoDeSuperarCantidadDeIntentosNoConsecutivos() {
		
		cerradura.abrir(1234);
		cerradura.abrir(223344);
		cerradura.cerrar();
		
		cerradura.abrir(1234);
		cerradura.abrir(223344);
		cerradura.cerrar();
		
		cerradura.abrir(1234);
		
		assertThat(cerradura.isBloqueada()).isEqualTo(false);
	}
	
	@Test
	public void siEstaBloqueadaQueNoSePuedaAbrir() {
		cerradura.abrir(1234);
		cerradura.abrir(12345);
		cerradura.abrir(12);
		cerradura.abrir(223344);
		
		assertThat(cerradura.isCerrada()).isEqualTo(true);
		
	}
		

}
