import java.util.Scanner;

public class Switch {
    public static void main(String [] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("\n-------------Ejemplo de uso de switch como sentencia-------------");
        System.out.printf("\nIngrese un número del 1 al 7: ");
        int numero = entrada.nextInt();

        switch(numero){
            case 1: //Lunes
                System.out.println("El número "+ numero + " corresponde al Lunes");
                break;
            case 2: //Martes
                System.out.println("El número "+ numero + " corresponde al Martes");
                break;
            case 3: //Miércoles
                System.out.println("El número "+ numero + " corresponde al Miércoles");
                break;
            case 4: //Jueves
                System.out.println("El número "+ numero + " corresponde al Jueves");
                break;
            case 5: //Viernes
                System.out.println("El número "+ numero + " corresponde al Viernes");
                break;
            case 6: //Sábado
                System.out.println("El número "+ numero + " corresponde al Sábado");
                break;
            case 7: //Domingo
                System.out.println("El número "+ numero + " corresponde al Domingo");
                break;
            default:
                System.out.println("Has ingresado un número no válido");
        }

        System.out.println("\n-------------Ejemplo de uso de switch como expresión-------------");
        System.out.printf("\nIngrese un número del 1 al 7: ");

        String dia = "Desconocido";
        dia = switch (numero){
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "Inválido";
        };
        System.out.println("\nEl número "+numero+" es "+dia);


        entrada.close();


    }
}
