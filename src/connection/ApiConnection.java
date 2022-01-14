package connection;

import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpResponse.BodyHandlers;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiConnection {

	public static void main(String[] args) throws Exception {
		// direccion de la api //esta es la clave de api
		String sentenciaAPI = "https://imdb-api.com/en/API/SearchMovie/k_pakc29xo/inception%202010";
		String sentenciaAPI2 = "https://imdb-api.com/en/API/Title/k_pakc29xo/tt1375666";

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(sentenciaAPI2);
		CloseableHttpResponse response = client.execute(request);

		HttpEntity entidad = response.getEntity();

		System.out.println(response.getStatusLine().getStatusCode()); //Imprime el codigo devuelto por la api
		String strIdentity = EntityUtils.toString(entidad);
		System.out.println(strIdentity);

		JSONObject myObject = new JSONObject(strIdentity);

		// Un campo concreto de un resultado
		System.out.println(myObject.getString("title"));
		System.out.println(myObject.getString("image"));

		response.close();
		client.close();

	}

}
