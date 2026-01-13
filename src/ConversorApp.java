import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("*************************************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda\r\n");

        String linea = "1) Dólar =>> Peso chileno"+System.lineSeparator()+
                "2) Peso chileno =>> Dólar"+System.lineSeparator()+
                "3) Dólar =>> Real brasileño"+System.lineSeparator()+
                "4) Real brasileño =>> Dólar"+System.lineSeparator()+
                "5) Dólar =>> Won coreano"+System.lineSeparator()+
                "6) Won coreano =>> Dólar"+System.lineSeparator()+
                "7) Salir" + System.lineSeparator()+
                "*************************************************************************";

        System.out.println(linea);
         int numeroDeConversion = 0;
         boolean salir = false;

         while ( !salir){
             try {
                    mostrarMenu(lectura);
                    numeroDeConversion = Integer.parseInt(lectura.nextLine());

                    if (numeroDeConversion < 1 || numeroDeConversion > 7) {
                        mostrarMenu(lectura);
                        numeroDeConversion = Integer.parseInt(lectura.nextLine());
                        continue;
                    }

                    if (numeroDeConversion == 7) {
                        System.out.println("Saliendo del programa...");
                        salir = true;
                        continue;
                    }

                    String monedaEntrada ="";
                    String monedaSalida ="";

                    switch (numeroDeConversion){
                        case 1:
                            monedaEntrada = "USD";
                            monedaSalida = "CLP";
                            break;
                        case 2:
                            monedaEntrada = "CLP";
                            monedaSalida = "USD";
                            break;
                        case 3:
                            monedaEntrada = "USD";
                            monedaSalida = "BRL";
                            break;
                        case 4:
                            monedaEntrada = "BRL";
                            monedaSalida = "USD";
                            break;
                        case 5:
                            monedaEntrada = "USD";
                            monedaSalida = "KRW";
                            break;
                        case 6:
                            monedaEntrada = "KRW";
                            monedaSalida = "USD";
                            break;

                    }
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double valor = Double.parseDouble(lectura.nextLine());

                    Moneda monedaConversion = consulta.buscaMoneda(monedaEntrada, monedaSalida);
                    //System.out.println(monedaConversion);

                    if (monedaConversion != null) {
                        double resultado = valor * monedaConversion.conversion_rate();


                        System.out.println("\n" + valor + " " + monedaEntrada +
                                " equivale a " + resultado + " " + monedaSalida);
                        System.out.println("Tasa de conversión: " + monedaConversion.conversion_rate());
                    } else {
                        System.out.println("Error al obtener la tasa de conversión");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese un número válido");
                } catch (Exception e) {
                 System.out.println("Error: " + e.getMessage());
                }

                if (!salir) {
                    System.out.println("\nPresione Enter para continuar...");
                    lectura.nextLine();
                }
         }
         lectura.close();

    }

    private static void mostrarMenu(Scanner lectura) {
        System.out.println("Elija una opción válida (1-7): ");
    }
}
