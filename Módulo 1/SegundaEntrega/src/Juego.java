import java.util.Scanner;

public class Juego {
    public static void main (String[] args){
        System.out.println("Juego");
        Scanner teclado =new Scanner(System.in); //2

        System.out.println("JUGADOR 1: Selecciona tu personaje [1-4]: ");
        int numero = teclado.nextInt();
        Personaje jugador1 = new Personaje(numero);
        System.out.println(jugador1);

        System.out.println("JUGADOR 2: Selecciona tu personaje [1-4]: ");
        numero = teclado.nextInt();
        Personaje jugador2 = new Personaje(numero);
        System.out.println(jugador2);

        //Pelea
        //Que jugador 1 golpee a jugador 2
        jugador1.golpear(jugador2);
        System.out.println(jugador1 + "\t\t\t\t" + jugador2);

        //Que jugador 2 golpee a jugador 1  2 VECES
        jugador2.golpear(jugador1);
        jugador2.golpear(jugador1);
        System.out.println(jugador1 + "\t\t\t\t" + jugador2);
    }
}
