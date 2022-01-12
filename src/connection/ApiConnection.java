package connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONObject;


public class ApiConnection {

    public static void main(String[] args) throws Exception {
                                        //direccion de la api          //esta es la clave de api
        String sentenciaAPI = "https://imdb-api.com/en/API/SearchMovie/k_pakc29xo/inception%202010";
        String sentenciaAPI2 = "https://imdb-api.com/en/API/Title/k_pakc29xo/tt1375666";


        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

        HttpResponse<String> response = client.send(HttpRequest.newBuilder(new URI(sentenciaAPI2))
                .headers("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0").GET()
                .build(), HttpResponse.BodyHandlers.ofString());

    //System.out.println(response.body());

     JSONObject myObject = new JSONObject(response.body());

     // Un campo concreto de un resultado
     System.out.println(myObject.getString("image"));


     // Para varios resultados
         //System.out.println(myObject.get("results")); 


    }

}


