
import modelo.ConvertidorMoneda;

import java.util.Scanner;

public class Principal {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ConvertidorMoneda convertidor = new ConvertidorMoneda();

        while (true) {
            mostrarMenu();
            String entrada = leerEntrada();

            // Obtener la opción del usuario
            int opcion;
            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número entero válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    realizarConversion(convertidor, "ARS", "USD");
                    break;
                case 2:
                    realizarConversion(convertidor, "USD", "ARS");
                    break;
                case 3:
                    realizarConversion(convertidor, "BRL", "USD");
                    break;
                case 4:
                    realizarConversion(convertidor, "USD", "BRL");
                    break;
                case 5:
                    realizarConversion(convertidor, "COP", "USD");
                    break;
                case 6:
                    realizarConversion(convertidor, "USD", "COP");
                    break;
                case 7:
                    System.out.println("¡Adiós!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida (1-7).");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n************************");
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Convertir ARS a USD");
        System.out.println("2. Convertir USD a ARS");
        System.out.println("3. Convertir BRL a USD");
        System.out.println("4. Convertir USD a BRL");
        System.out.println("5. Convertir COP a USD");
        System.out.println("6. Convertir USD a COP");
        System.out.println("7. Salir");
    }

    private static String leerEntrada() {
        System.out.print("Opción: ");
        return scanner.nextLine().trim();
    }

    private static void realizarConversion(ConvertidorMoneda convertidor, String monedaOrigen, String monedaDestino) {
        double monto = obtenerMontoValido();

        double montoConvertido = convertidor.convertir(monedaOrigen, monedaDestino, monto);

        System.out.println(monto + " " + monedaOrigen + " = " + montoConvertido + " " + monedaDestino);
    }

    private static double obtenerMontoValido() {
        while (true) {
            System.out.print("Ingrese el monto a convertir: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                // Si no se ingresa ningún valor, solicitar nuevamente la entrada
                System.out.println("Error: Por favor ingrese un valor.");
                continue;
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
    }
}
