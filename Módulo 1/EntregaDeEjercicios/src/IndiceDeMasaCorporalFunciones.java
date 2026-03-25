import java.util.Scanner;
public class IndiceDeMasaCorporalFunciones {

    /**
     * Función para calcular el Índice de Masa Corporal (IMC).
     * @param peso Peso de la persona en kilogramos.
     * @param altura Altura de la persona en metros.
     * @return El valor del IMC.
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Función para clasificar el estado de peso basado en el IMC.
     * @param imc El Índice de Masa Corporal calculado.
     * @return Una cadena de texto con la clasificación del peso.
     */
    public static String clasificarIMC(double imc) {
        String clasificacion;

        // Uso de la sentencia if-else anidada para la clasificación
        if (imc < 18.5) {
            clasificacion = "Bajo peso, coma con doble tortilla";
        } else if (imc < 24.9) {
            clasificacion = "Peso normal";
        } else if (imc < 29.9) {
            clasificacion = "Sobrepeso, realice un poco de actividad física";
        } else {

            clasificacion = "Obesidad, consulte a un especialista.";
        }

        return clasificacion;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.printf("\nIntresa tu peso en Kg: ");
        double peso = entrada.nextDouble();
        System.out.printf("Ingresa tu estatura en metros: ");
        double altura = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("\n--- Cálculo y Clasificación del IMC ---");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + altura + " m");

        // 1. Llamar a la función para calcular el IMC
        double imcCalculado = calcularIMC(peso, altura);

        // 2. Llamar a la función para clasificar el resultado
        String estadoPeso = clasificarIMC(imcCalculado);

        System.out.printf("\nIMC calculado: %.2f\n", imcCalculado);
        System.out.println("Clasificación: " + estadoPeso);
        System.out.println("----------------------------------------");
        entrada.close();
    }
}