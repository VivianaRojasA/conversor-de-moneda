import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscaMoneda(String monedaEntrada, String monedaSalida) throws Exception {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/27ff99f1950b9fce22582b7b/pair/"
                +monedaEntrada+"/"+monedaSalida+"/");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(direccion)
                .GET()
                .build();

        try {
            // Enviando solicitud y recibiendo respuesta
            HttpResponse <String> respuesta = client.send(solicitud, HttpResponse.BodyHandlers.ofString());

            //if (respuesta.statusCode() != 200) {
            //    System.out.println("Error en la API: Código " + respuesta.statusCode());
            //    return null;
            //}

            //Parsear la respuesta JSON
            String json = respuesta.body();
            Gson gson = new Gson();

            return gson.fromJson(json, Moneda.class);

        } catch (Exception e){
            System.out.println("Error al consultar la API: " + e.getMessage());
            return null;
        }
    }
}
