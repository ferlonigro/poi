package tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import domain.POI;
import services.POIMasCercanoService;

public class ServicioDistanciasTest {

	@Test
	public void poisMasCercanoDesdeLunaPark() {
		
		POIMasCercanoService service = new POIMasCercanoService();
		POI poi = service.getPoisMasCercano("Baires Turistico", -34.602021, -58.368360);

		assertThat(poi.getNombre()).containsIgnoringCase("palacio");
	}
	

	
}
