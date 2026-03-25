// Ejemplo de uso de equals()

public class PruebaMetodosComunes {
    public static void main(String[] args){
        System.out.println("\n-----Métodos comunes en las clases------");
        System.out.println("equals()");

        Libro libroA = new Libro("El principito", 1,"Antoine de Saint-Exupéry");
        Libro libroB = new Libro("El principito", 1,"Antoine de Saint-Exupéry");

        if (libroA == libroB) // Pregunta por referencias
            System.out.println("iguales");
        else
            System.out.println("diferentes");

        if(libroA.equals(libroA)) //Pregunta por "contenido"
            System.out.println("Para equals () son iguales");
        else
            System.out.println("Para equals () son diferentes");

        System.out.println("Hash code: " + libroA.hashCode());
        System.out.println("Hash code: " + libroB.hashCode());

        System.out.println("\n----------compareTo()----------");
        Alumno uno = new Alumno("José","316201191","Ingeniería mecatrónica");
        Alumno dos = new Alumno("Marco", "123456","Veterinaria");

        System.out.println(uno.compareTo(dos)); //Positivo
        System.out.println(dos.compareTo(uno)); //Negativo

    }
}
