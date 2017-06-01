package tests;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;


public class POIsAceptacionIT {
	
	private static String BASE_URL = "http://localhost";
	private static String BASE_PORT = "9090";

	@Test
	public void traeServiciosT() throws IOException{
		POI poi = new POI("Buenos Aires Turístico");
		
		String URL = BASE_URL + ":" + BASE_PORT + "/pois/"+ poi.getServicio();
	    PeticionPost post = new PeticionPost(URL);
	    
	    String respuesta = post.post();
	    Assert.assertEquals(true, respuesta.contains("LAS CUARTETAS"));
	    Assert.assertEquals(false, respuesta.contains("LOS CUARTETAS4"));
	    
	    Assert.assertEquals(true, respuesta.contains("BOMBONERA"));
	    Assert.assertEquals(false, respuesta.contains("BOM4"));
	    
	    Assert.assertEquals(true, respuesta.contains("EL CUARTITO"));
	    Assert.assertEquals(false, respuesta.contains("LA CUARTITO4"));
	    
	    Assert.assertEquals(true, respuesta.contains("EL PALACIO DE LA PIZZA"));
	    Assert.assertEquals(false, respuesta.contains("LA PALACIO DE LA PIZZA4"));
	    
	    Assert.assertEquals(true, respuesta.contains("MONUMENTAL"));
	    Assert.assertEquals(false, respuesta.contains("HELADERA4"));
	    
	    Assert.assertEquals(true, respuesta.contains("OBELISCO"));
	    Assert.assertEquals(false, respuesta.contains("OBELI4"));
	}
	
	@Test
	public void traeServiciosH() throws IOException{
		POI poi = new POI("Buenos Aires Historico");
		
		String URL = BASE_URL + ":" + BASE_PORT + "/pois/"+ poi.getServicio();
	    PeticionPost post = new PeticionPost(URL);
	    
	    String respuesta = post.post();
	    Assert.assertEquals(true, respuesta.contains("CABILDO"));
	    Assert.assertEquals(false, respuesta.contains("CABIL4"));
	    
	    Assert.assertEquals(true, respuesta.contains("PLAZA DE MAYO"));
	    Assert.assertEquals(false, respuesta.contains("PLAZA DE4"));
	    
	    Assert.assertEquals(true, respuesta.contains("COVENTO SAN FRANCISCO"));
	    Assert.assertEquals(false, respuesta.contains("COVENTO SAN4"));
	    
	    Assert.assertEquals(true, respuesta.contains("COVENTO SANTO DOMINGO"));
	    Assert.assertEquals(false, respuesta.contains("COVENTO SANTO4"));
	    
	    Assert.assertEquals(true, respuesta.contains("CAFE DE LOS ANGELITOS"));
	    Assert.assertEquals(false, respuesta.contains("CAFE DE LOS4"));
	}
	
	@Test
	public void traeServiciosInexistente() throws IOException{
		POI poi = new POI("Inexistente");
		
		String URL = BASE_URL + ":" + BASE_PORT + "/pois/"+ poi.getServicio();
	    PeticionPost post = new PeticionPost(URL);
	    
	    String respuesta = post.post();
	    Assert.assertEquals(true, respuesta.compareToIgnoreCase("INEXISTENTE"));
	}
	
	@Test
	public void DadoQueEstoyEnLunaParkPidoPOICercanoDelServicioBsAsTuristicoYDevuelveElPalacioDeLaPizza() throws IOException{
		String latLunaPark = "-34,6020166";
		String lonLunaPark = "-58,3705487";
		POI poiTuristico = new POI("Buenos Aires Turístico");
		
		String URL = BASE_URL + ":" + BASE_PORT + "/poismascercano/"+ poiTuristico.getServicio() + latLunaPark +"/"+ lonLunaPark;
	    PeticionPost post = new PeticionPost(URL);
	    
	    String respuesta = post.post();
	    Assert.assertEquals(true, respuesta.contains("EL PALACIO DE LA PIZZA"));
	}
	
	@Test
	public void DadoQueEstoyEnCongresoPidoPOICercanoDelServicioBsAsHistoricoYDevuelveCafeDeLosAngelitos() throws IOException{
		String latCongreso = "-34,6098164";
		String lonCongreso = "-58,3947948";
		POI poiHistorico = new POI("Buenos Aires Historico");
		
		String URL = BASE_URL + ":" + BASE_PORT + "/poismascercano/"+ poiHistorico.getServicio() + latCongreso +"/"+ lonCongreso;
		PeticionPost post = new PeticionPost(URL);
	    
	    String respuesta = post.post();
	    Assert.assertEquals(true, respuesta.contains("CAFE DE LOS ANGELITOS")); 
	}
	
}
