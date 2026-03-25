/*Programa realizado por:
* José Ángel Olmedo Guevara*/
import java.util.Scanner;

public class Practica1 {

    public static void evaluarEdad(int edad){
        //Si es mayor edad o no
        if (edad >= 18) {
            System.out.printf("Es mayor de edad");
        } else {
            System.out.printf("Es menor de edad");
        }
    }

    //(que reciba su promedio y total de créditos) que regresa si es “Regular” o “Irregular”.
    public static String estadoAcademico(double promedio, int creditos){
        if (promedio >= 8 && creditos > 20) {
            return "Regular";
        } else {
            // Irregular en cualquier otro caso
            return "Irregular";
        }
    }

    public static void evaluarElegibilidadBeca(double promedio, int creditos){
        if (promedio >= 9 && creditos >= 30) {
            System.out.printf("\nEs elegible para beca");
        } else {
            System.out.printf("\nNo es elegible para beca");
        }
    }

    public static void main(String[] args) {

        //Creamos objeto entrada para leer desde terminal
        Scanner entrada = new Scanner(System.in);
        String continuar = "";

        do {

            String nombre = "";
            int edad = 0;
            int materias = 0;
            double promedio = 0.0;
            int creditos = 0;

            System.out.println("\nProporcione los datos del estudiante para evaluar su situación académica: ");

            System.out.printf("\nProporcion el nombre: ");
            nombre = entrada.nextLine();
            System.out.printf("Proporcione la edad: ");
            edad = entrada.nextInt();
            System.out.printf("Proporcione el número de materias cursadas: ");
            materias = entrada.nextInt();
            System.out.printf("Proporcione el promedio: ");
            promedio = entrada.nextDouble();
            System.out.printf("Proporcione los créditos cursados: ");
            creditos = entrada.nextInt();

            entrada.nextLine(); //Limpiamos buffer

            System.out.println("\nResultado del análisis: \n");

            evaluarEdad(edad);
            String estado = estadoAcademico(promedio, creditos);
            System.out.printf("\nEstado académico: " + estado);
            evaluarElegibilidadBeca(promedio, creditos);


            //Considerando que las carreras son de 120 créditos, calcule y muestre el porcentaje de créditos que le faltan
            double faltante = 100 - (((double) creditos * 100) / 120);
            System.out.printf("\nPorcentaje de créditos faltantes: %.2f", faltante);

            System.out.printf("\n\n¿Desea saber la situación académica de otro estudiante? (s/n): ");
            continuar = entrada.nextLine().toLowerCase();

        } while(continuar.equals("s"));
        System.out.println("\n\n------------Consultas finalizadas------------\n\n");
        entrada.close();
    }
}