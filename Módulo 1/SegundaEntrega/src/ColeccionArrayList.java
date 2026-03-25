import java.util.ArrayList;

public class ColeccionArrayList {
    public static void saltoDeLinea(){
        System.out.println("");
    }

    public static void main(String[] args){
        saltoDeLinea();
        System.out.println("Colección ArrayList");
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        saltoDeLinea();

        numeros.add(30);
        numeros.add(40);
        numeros.add(50);
        System.out.println(numeros + ": "+numeros.size());
        System.out.println(numeros.get(1));  // Extracción de un elemento
        System.out.println(numeros.contains(50)); // Prueba de existencia
        System.out.println(numeros.indexOf(50)); // Ubica la posición de un elemento

        saltoDeLinea();
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Hugo");
        nombres.add("Paco");
        nombres.add("Luis");
        System.out.println(nombres);
        nombres.add(1,"Wilson");
        nombres.addFirst("Jeff");
        nombres.addLast("Mike");

        System.out.println(nombres);
    }
}
