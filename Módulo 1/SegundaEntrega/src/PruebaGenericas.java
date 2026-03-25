public class PruebaGenericas {
    public static void saltoDeLinea(){
        System.out.println("");
    }
    public static void main(String[] args) {
        System.out.println("\nPrueba de clases genéricas\n");

        ClaseGenerica<Integer> objeto1 = new ClaseGenerica<Integer>(); // Las clases genéricas esperan clases, no tipos primitivos
        // En objeto1, edad será Integer
        objeto1.edad = 33;
        objeto1.imprime(55);
        System.out.println(objeto1);

        saltoDeLinea();

        ClaseGenerica<Double> objeto2 = new ClaseGenerica<Double>();
        objeto2.edad = 33.3;
        objeto2.imprime(55.5);
        System.out.println(objeto2);

        saltoDeLinea();

        ClaseGenerica<String> objeto3 = new ClaseGenerica<String>();
        objeto3.edad = "33.3";
        objeto3.imprime("Saludos");
        System.out.println(objeto3);

        saltoDeLinea();

        ClaseGenerica<Paciente> objeto4 = new ClaseGenerica<Paciente>();
        objeto4.edad = new Paciente();
        System.out.println(objeto4);

    }
}
