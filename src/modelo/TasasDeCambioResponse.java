package modelo;
import com.google.gson.Gson;

import java.util.Map;

public class TasasDeCambioResponse {
    private String resultado;

    // Otros campos del JSON que no necesitamos para esta implementación
    private Map<String, Double> tasasDeCambio;


    // Método para obtener las tasas de conversión
    public Map<String, Double> getConversionRates() {
        return tasasDeCambio;
    }

    // Método para parsear el JSON
    public static TasasDeCambioResponse fromJson(String json) {
        Gson gson = new Gson();

        return gson.fromJson(json, TasasDeCambioResponse.class);
    }
}