import java.util.Scanner;

public class Ciclos {
    public static void main(String [] args){

        System.out.println("\nCiclos");
        System.out.println("\tWhile");

        //Ciclo cuando conozco el número de vueltas / iteraciones
        int vueltas = 100;
        int contador = 0;
        while(contador++ < vueltas){
            System.out.println("Dando la vuelta "+contador);
            //contador++;
        }

        //Cuando solo cnozco la condición de parada // finalización
        int numero = 0;
        int aleatorio = 77;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Juguemos a adivinar el número que pensé....");
        while(numero != aleatorio){
            System.out.print("Dame el número que pensaste: ");
            numero = entrada.nextInt();
        }
        System.out.println("Lo adivinaste!");

        numero = 14;
        aleatorio = 14;
        do{
            System.out.print("Dame el número que pensaste: ");
            numero = entrada.nextInt();

        } while (numero != aleatorio);
        System.out.println("Fin del programa");

    }
}
