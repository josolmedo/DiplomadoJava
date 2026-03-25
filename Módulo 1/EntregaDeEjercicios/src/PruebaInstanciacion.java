public class PruebaInstanciacion {

    public static void main(String[] args) {

        System.out.println("--- 1. Creación de Objetos (Instanciación) ---");

        // Instancia 1: Creamos el objeto 'casaRural' de la clase 'Casa'.
        // Usamos el constructor para darle valores iniciales.
        Casa casaRural = new Casa("Blanco", 1, 150.0);

        // Instancia 2: Creamos otro objeto 'apartamento' con características diferentes.
        Casa apartamento = new Casa("Gris", 5, 80.5);

        // Acceder a un atributo y modificarlo directamente
        apartamento.tieneJardin = false; // Aunque el valor por defecto era false, se puede modificar
        casaRural.tieneJardin = true; // La casa rural sí tiene jardín


        System.out.println("\n--- 2. Interacción con el Objeto Casa Rural ---");

        System.out.println("Estado inicial de la casa rural:");
        casaRural.mostrarEstado();

        // Llamar a un método que modifica un atributo
        casaRural.pintarCasa("Amarillo");

        // Llamar a un método que devuelve un valor
        double costo = casaRural.calcularCostoPintura(5.5); // 5.5 es el costo por m²
        System.out.printf("Costo total para pintar la casa rural: $%.2f\n", costo);

        // Mostrar el estado final (se ve el nuevo color)
        casaRural.mostrarEstado();


        System.out.println("\n--- 3. Interacción con el Objeto Apartamento ---");

        System.out.println("Estado inicial del apartamento:");
        apartamento.mostrarEstado();

        // Acceder directamente a un atributo para leer su valor
        System.out.println("El apartamento tiene " + apartamento.numPisos + " pisos.");
    }
}