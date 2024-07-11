import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        Scanner input = new Scanner(System.in);

        try{
            while (true){
                System.out.println("Ingrese la moneda de origen\nComo por ejemplo: \nARS\nUSD\nBRA\nO bien ingrese Salir para finalizar el prgrama");
                String monedaOrigen = input.next().toLowerCase();

                if (monedaOrigen.equalsIgnoreCase("salir")){
                    break;
                }else {

                    System.out.println("Ingrese la cantidad");
                    double cantidad = input.nextDouble();

                    System.out.println("Ingrese la moneda de destino");
                    String monedaDestino = input.next().toUpperCase();

                    ConsultaMoneda consulta = new ConsultaMoneda();

                    double tasaConversion = consulta.obtenerConversion(monedaOrigen, monedaDestino);

                    if (tasaConversion != 0) {
                        // Calcular la cantidad convertida
                        double cantidadConvertida = cantidad * tasaConversion;

                        // Mostrar el resultado
                        System.out.println(cantidad + " " + monedaOrigen + " equivale a " + cantidadConvertida + " " + monedaDestino);
                    } else {
                        System.out.println("No se pudo obtener la tasa de conversión.");
                    }
                }

        }

        } catch (Exception e) {
            System.out.println("No se pudo convertir la moneda");  e.getMessage();

        }


    }
}
