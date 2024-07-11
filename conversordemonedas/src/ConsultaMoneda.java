import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public double obtenerConversion (String origen, String destino) throws URISyntaxException, IOException, InterruptedException {
        URI direccion = new URI("https://v6.exchangerate-api.com/v6/7a870166ee0f747e6b7da4a0/latest/" + origen);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();
        System.out.println();

        Gson gson = new Gson();
        JsonObject jsonresponse = gson.fromJson(responseBody, JsonObject.class);
        JsonObject conversionRates = jsonresponse.getAsJsonObject("conversion_rates");

        if (conversionRates.has(destino)) {
            return conversionRates.get(destino).getAsDouble();
        } else {
            System.out.println("La origen especificada no está disponible.");
        }
        return 0;
    }



}
