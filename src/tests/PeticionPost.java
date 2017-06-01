package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;


/**
 *
 * EnvÃ­a una comando HTTP POST a una URL y es recibe la respuesta 
 * 
 * @author Pablo Chamorro
 *
 */
public class PeticionPost {
	private URL url;
	String data;

	public PeticionPost(String url) throws MalformedURLException {
		this.url = new URL(url);
		data = "";
	}

	public void add(String propiedad, String valor)
			throws UnsupportedEncodingException {
		// codificamos cada uno de los valores
		if (data.length() > 0)
			data += "&" + URLEncoder.encode(propiedad, "UTF-8") + "="
					+ URLEncoder.encode(valor, "UTF-8");
		else
			data += URLEncoder.encode(propiedad, "UTF-8") + "="
					+ URLEncoder.encode(valor, "UTF-8");
	}

	public String post() throws IOException {
		String respuesta = "";

		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data);
		wr.close();

		BufferedReader rd = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String linea;
		while ((linea = rd.readLine()) != null) {
			respuesta += linea;
		}
		return respuesta;
	}

	public String getData() {
		return data;
	}

	public URL getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		if (data.length()>0) {
			try {
				return  url.toString() + "?" + URLDecoder.decode(data, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return  url.toString() + "?" + data;
			}
		} else {
			return  url.toString();
		}
	}

}