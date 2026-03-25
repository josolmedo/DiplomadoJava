public class Arreglos {
    public static void main(String[] args){

        System.out.println("\n------------Arreglos------------");
        //tipo [] nombre = new tipo [tamaño]
        //tipo [] nombre = {lista de valores del tipo especificado}

        System.out.println("Arreglos de tipos de datos primitivos");
        double [] calificaciones = new double [18];


        System.out.println("Elemento con índice 6: "+ calificaciones[6]);
        calificaciones[6]=9.76;
        System.out.println("Elemento con índice 6: "+calificaciones[6]);

        System.out.println(calificaciones);
        //Para imprimir todos los elementos del arreglo
        for(int i = 0; i < 18; i++){
            System.out.println("Elemento con índice "+ i +" = "+calificaciones[i]);

        }

        int numero = 0;
        while(numero < 10){
            System.out.println("Elemento con índice "+numero+" = "+calificaciones[numero]);
            numero++;
        }

        System.out.println("\nArreglos de objetos");
        String [] estudiantes = {"José", "Marco", "María", "Fernanda"};
        int[] asistencias = {8,7,8,8};
        System.out.println(asistencias.length); //4
        asistencias = new int[5];
        System.out.println(asistencias.length); //5

        for(int i = 0; i < estudiantes.length; i++){
            System.out.println("Estudiante con índice "+ i +" = "+calificaciones[i]);

        }

        // ==========================================================
        System.out.println("\n--- 2. ARREGLOS BIDIMENSIONALES (Matrices) ---");
        // ==========================================================

        // Declaración e inicialización de una matriz de 3 filas y 2 columnas
        // Representa (Fila, Columna) -> (Sujeto, Calificación)
        int[][] calificaciones2 = {
                {8, 9}, // Fila 0
                {7, 8}, // Fila 1
                {9, 7}  // Fila 2
        };

        // Acceder a la longitud
        int numFilas = calificaciones2.length;        // Número de filas (3)
        int numColumnas = calificaciones2[0].length; // Número de columnas (2, basado en la fila 0)

        System.out.println("La matriz tiene " + numFilas + " filas y " + numColumnas + " columnas.");

        // 2.1 Iteración con ciclos FOR anidados
        System.out.println("\nVisualización de la matriz (Filas x Columnas):");

        // El ciclo externo recorre las FILAS
        for (int fila = 0; fila < numFilas; fila++) {
            System.out.print("Sujeto " + (fila + 1) + ": | ");

            // El ciclo interno recorre las COLUMNAS de la fila actual
            for (int columna = 0; columna < numColumnas; columna++) {
                // Se accede al elemento usando [fila][columna]
                System.out.print(calificaciones2[fila][columna] + " | ");
            }
            System.out.println(); // Salto de línea al terminar una fila
        }



    }
}
