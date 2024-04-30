package modelo;

import challengeConversorDeMonedas.com.controladora.Controladora;

public class ConvertidorMoneda {
    public double convertir(String monedaOrigen, String monedaDestino, double monto) {
        double tasaCambio = Controladora.consultaTasaDeCambio(monedaDestino);
        double tasaCambioInversa = Controladora.consultaTasaDeCambio(monedaOrigen);

        if (monedaOrigen.equals("USD")) {
            return monto * tasaCambio;
        } else if (monedaDestino.equals("USD")) {
            return monto / tasaCambioInversa;
        } else {
            double montoEnUSD = monto / tasaCambioInversa;
            return montoEnUSD * tasaCambio;
        }
    }
}
