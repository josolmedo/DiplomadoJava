public class OperadorTernario {

    public static void main(String[] args) {

        System.out.println("\n------Ejemplos de operadores lógicos------");
        int edad = 25;
        char genero = 'M';
        String resultado;


        // Sintaxis: (condición) ? valor_si_verdadero : valor_si_falso;
        // ¿Está obligado a realizar el SMN?
        resultado = (edad >= 18 ) && (genero == 'M') ? "\nEstá obligado": "\nNo estás obligado";
        System.out.println(resultado);

        // ¿Está obligado a realizar el SMN?
        edad = 17;

        resultado = (edad >= 18 ) && (genero == 'M') ? "\nEstá obligado": "\nNo estás obligado";
        System.out.println(resultado);

        // --- Otro Ejemplo Rápido: Asignar un valor numérico ---
        int a = 10;
        int b = 20;
        int maximo;

        // Si 'a' es mayor que 'b', el máximo es 'a', sino es 'b'.
        maximo = (a > b) ? a : b;

        System.out.println("\n--- Ejemplo de Asignación Numérica ---");
        System.out.println("El número máximo entre " + a + " y " + b + " es: " + maximo);
    }
}