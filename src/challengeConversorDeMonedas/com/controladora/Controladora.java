package challengeConversorDeMonedas.com.controladora;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Controladora {

    private static final URI DIRECCION = URI.create("https://v6.exchangerate-api.com/v6/81f5fbcd589dd1f9bdc95a31/latest/USD");

    // Método para consultar la tasa de cambio para una moneda específica
    public static double consultaTasaDeCambio(String codigoMoneda) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(DIRECCION)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Deserializar la respuesta JSON en un objeto JsonObject
            JsonObject json = new Gson().fromJson(response.body(), JsonObject.class);

            // Extraer el objeto JSON correspondiente campo "conversion_rates"
            JsonObject conversionRates = json.getAsJsonObject("conversion_rates");

            // Obtener la tasa de cambio correspondiente al código de moneda especificado
            return conversionRates.get(codigoMoneda).getAsDouble();
        } catch (IOException | InterruptedException e) {
            // Manejar adecuadamente la excepción
            throw new RuntimeException("Error al consultar las tasas de cambio", e);
        }
    }
}