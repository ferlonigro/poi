package tests;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import util.DistanceCalculator;

public class AlgoritmoDistanciasTest {

	@Test
	public void DistanciaEntreEstadioRiverYLasCuartetas() {
		float distancia = DistanceCalculator.getDistance(-34.60375, -58.3807633, -34.5453062, -58.4519636);
		assertThat(distancia).isBetween(9000F, 9400F);
	}
	
	@Test
	public void DistanciaEntreEstadioRiverYEstadioRiver() {
		float distancia = DistanceCalculator.getDistance(-34.60375, -58.3807633, -34.60375, -58.3807633);
		assertThat(distancia).isEqualTo(0F);
	}
	
	
}
