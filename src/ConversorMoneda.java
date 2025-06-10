import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ConversorMoneda {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaDivisa consulta = new ConsultaDivisa();
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();

            try {
                int opcion = Integer.parseInt(lectura.nextLine());

                switch (opcion) {
                    case 1:
                        convertirMoneda(lectura, consulta, "USD", "COP");
                        break;
                    case 2:
                        convertirMoneda(lectura, consulta, "USD", "BRL");
                        break;
                    case 3:
                        convertirMoneda(lectura, consulta, "USD", "ARS");
                        break;
                    case 4:
                        convertirMoneda(lectura, consulta, "USD", "EUR");
                        break;
                    case 5:
                        convertirMoneda(lectura, consulta, "COP", "USD");
                        break;
                    case 6:
                        convertirMoneda(lectura, consulta, "BRL", "USD");
                        break;
                    case 7:
                        convertirMoneda(lectura, consulta, "ARS", "USD");
                        break;
                    case 8:
                        convertirMoneda(lectura, consulta, "EUR", "USD");
                        break;
                    case 0:
                        System.out.println("Saliendo del Conversor de Monedas!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Ingrese un número del menú.");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Finalizando la aplicación.");
                continuar = false;
            }

            System.out.println(); // Línea en blanco
        }

        lectura.close();
    }

    private static void mostrarMenu() {
        System.out.println("""
            ===========================================
                Bienvenid@ al Conversor de Monedas
            -------------------------------------------
            Elija la opción que desee:

            1) Dólar a Peso colombiano
            2) Dólar a Real brasileño
            3) Dólar a Peso argentino
            4) Dólar a Euro
            5) Peso colombiano a Dólar
            6) Real brasileño a Dólar
            7) Peso argentino a Dólar
            8) Euro a Dólar
            0) Salir
            ===========================================
            """);
    }

    private static void convertirMoneda(Scanner lectura, ConsultaDivisa consulta, String monedaInicial, String monedaFinal) {
        System.out.println("Ingrese valor a convertir: ");
        try {
            var valor = Double.valueOf(lectura.nextLine());
            Divisa divisa = consulta.buscaDivisa(monedaInicial, monedaFinal, valor);
            double resultado = divisa.conversion_result();
            BigDecimal redondeado = new BigDecimal(resultado).setScale(2, RoundingMode.HALF_UP);
            System.out.println("El valor " + valor + " " + monedaInicial + " equivale a " + redondeado + " " + monedaFinal + ".");
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Asegúrese de ingresar un número con formato [0.0].");
        } catch (RuntimeException e) {
            System.out.println("No se pudo realizar la conversión: " + e.getMessage());
        }
    }
}
