package repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import domain.POI;

public class POIRepository {
	private static String POIsPath = "pois.txt";
	private static Gson gson = new GsonBuilder().create();
	private static POI[] pois;
	static {
		try {
			load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Set<POI> result = new HashSet<POI>();
	public POI[] getPois(String servicio) {
		for (POI poi : pois) {
			if (poi.getServicio().equalsIgnoreCase(servicio)) {
				result.add(poi);
			}
		}
		
		if (result.isEmpty()) {
			return null;
		} else {
			return result.toArray(new POI[result.size()]);
		}
		
	}
	
	private static void load() throws IOException {
//		byte[] jsonBytes = Files.readAllBytes(Paths.get(POIsPath));
//		String json = new String(jsonBytes);
		String str = "[{\"id\":1,\"latitud\":-34.608689,\"longitud\":-58.373528,\"nombre\":\"CABILDO\",\"descripcion\":\"Edificio que albergó al ayuntamiento, el cual, con modificaciones en su estructura, es hoy el Museo Histórico Nacional del cabildo y de la Revolución de Mayo \",\"servicio\":\"Bs As Historico\"}," +
				"{\"id\":2,\"latitud\":-34.608333,\"longitud\":-58.371944,\"nombre\":\"PLAZA DE MAYO\",\"descripcion\":\"Sitio funcional de la ciudad de Buenos Aires, Argentina, nació de la unión de las plazas de La Victoria y del Fuerte, al demolerse, en 1884, una construcción llamada Recova Virgen, que las separaba\",\"servicio\":\"Bs As Historico\"}," +
				"{\"id\":3,\"latitud\":-34.60375,\"longitud\":-58.3807633,\"nombre\":\"LAS CUARTETAS\",\"descripcion\":\"Pizzería clásica del céntrico Barrio de San Nicolás, en la Ciudad de Buenos Aires, Argentina. La cuarteta es una estrofa de cuatro versos de arte menor con rima consonante\",\"servicio\":\"Baires Turistico\"}," +
				"{\"id\":4,\"latitud\":-34.6106031,\"longitud\":-58.3737006,\"nombre\":\"COVENTO SAN FRANCISCO\",\"descripcion\":\"La Basílica y Convento de San Francisco de Asís es un templo católico que se encuentra en calle Alsina 380, en el casco histórico de la Ciudad de Buenos Aires (Argentina), barrio de Monserrat. Perteneció a la orden de los franciscanos, la primera que recibió un terreno en el asentamiento fundado por Juan de Garay en 1580\",\"servicio\":\"Bs As Historico\"}," +
				"{\"id\":5,\"latitud\":-34.6125709,\"longitud\":-58.3740097,\"nombre\":\"COVENTO SANTO DOMINGO\",\"descripcion\":\"La Basílica de Nuestra Señora del Rosario y Convento de Santo Domingo de la Ciudad de Buenos Aires es un templo católico ubicado en el barrio de Monserrat que data de mediados del siglo XVIII y que fue declarado Monumento Histórico Nacional en 1942\",\"servicio\":\"Bs As Historico\"}," +
				"{\"id\":6,\"latitud\":-34.6349438,\"longitud\":-58.3662645,\"nombre\":\"BOMBONERA\",\"descripcion\":\"El Estadio Alberto J. Armando, mundialmente conocido como La Bombonera, es un estadio de fútbol, propiedad del Club Atlético Boca Juniors. Tiene una capacidad para 49.145 espectadores. Por su aforo, es el séptimo estadio argentino\",\"servicio\":\"Baires Turistico\"}," +
				"{\"id\":7,\"latitud\":-34.5978366,\"longitud\":-58.3854565,\"nombre\":\"EL CUARTITO\",\"descripcion\":\"El Cuartito es una histórica pizzería ubicada en Barrio Norte que prepara pizzas al clásico estilo porteño. Su salón, siempre lleno, está atiborrado de fotos de grandes glorias del deporte y el espectáculo que abarcan toda la historia de la pizzería.\",\"servicio\":\"Baires Turistico\"}," +
				"{\"id\":8,\"latitud\":-34.6033254,\"longitud\":-58.3795235,\"nombre\":\"EL PALACIO DE LA PIZZA\",\"descripcion\":\"Pizzas \",\"servicio\":\"Baires Turistico\"}," +
				"{\"id\":9,\"latitud\":-34.5453062,\"longitud\":-58.4519636,\"nombre\":\"MONUMENTAL\",\"descripcion\":\"Monumental de Nuñez - Estadio River Plate - Visiblemente desde el cielo! El más lindo!\",\"servicio\":\"Baires Turistico\"}," +
				"{\"id\":10,\"latitud\":-34.6096435,\"longitud\":-58.4023932,\"nombre\":\"CAFE DE LOS ANGELITOS\",\"descripcion\":\"Café y algo más.\",\"servicio\":\"Bs As Historico\"}," +
				"{\"id\":11,\"latitud\":-34.6037389 ,\"longitud\":-58.3837591 ,\"nombre\":\"OBELISCO\",\"descripcion\":\"Monumento pétreo con forma de pilar\",\"servicio\":\"Baires Turistico\"}]";
		pois = gson.fromJson(str, POI[].class);
		
//		pois = gson.fromJson(json, POI[].class);
	}
}
