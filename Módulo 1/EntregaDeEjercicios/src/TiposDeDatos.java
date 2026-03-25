public class TiposDeDatos {

    public static void main (String [] args){
        /*Este es un ejemplo
        de comentario
        que ocupa más de una línea
         */

        //Una sola línea
        /*Secuencias de escape*/

        // \n \r \t
        System.out.println("Universidad Nacional Autónoma de México");
        System.out.println("Universidad Nacional \nAutónoma de México");
        System.out.println("Universidad Nacional \tAutónoma de México");
        System.out.println("Universidad Nacional \rAutónoma de México");


        System.out.println("""
                Texto
                que
                debe
                imprimir""");

        // --- DECLARACIÓN DE VARIABLES Y LÓGICA MOVIDA AQUÍ ---

        // byte: Ocupa 8 bits, rango muy pequeño (-128 a 127). Útil para ahorrar espacio.
        // Las variables locales (dentro del método) no necesitan ser inicializadas antes de usarse,
        // pero es buena práctica hacerlo.
        byte edad = 25;

        // short: Ocupa 16 bits, rango mayor que byte.
        short anioNacimiento = 2000;

        // int: Ocupa 32 bits, es el más común para números enteros.
        int poblacionMundial = 800000000; // Aproximado

        // long: Ocupa 64 bits, para números muy grandes. Se recomienda usar la 'L' al final.
        long distanciaEstrella = 9461000000000000L;

        // float: Ocupa 32 bits, precisión simple. Se recomienda usar la 'f' al final.
        float temperatura = 25.5f;

        // double: Ocupa 64 bits, precisión doble. Es el tipo por defecto para decimales.
        double pi = 3.1415926535;

        // char: Ocupa 16 bits (Unicode), almacena un solo carácter.
        char inicial = 'J';

        // boolean: Ocupa un bit (conceptualmente), solo puede ser 'true' o 'false'.
        boolean esMayorDeEdad = true;

        //////////////////////////////////////////////////////////////////////////////////////

        // String: Aunque parece primitivo, es una clase (un objeto) que maneja cadenas de caracteres.
        String nombreCompleto = "José Olmedo";

        // --- Sentencias de Impresión ---

        System.out.println("\n--- Ejemplos de Tipos de Datos en Java ---");
        System.out.println("\n*** Tipos Primitivos ***");

        System.out.println("byte (Edad): " + edad);
        System.out.println("short (Año de Nacimiento): " + anioNacimiento);
        System.out.println("int (Población Mundial): " + poblacionMundial);
        System.out.println("long (Distancia a Estrella): " + distanciaEstrella);
        System.out.println("float (Temperatura): " + temperatura);
        System.out.println("double (Valor de Pi): " + pi);
        System.out.println("char (Inicial): " + inicial);
        System.out.println("boolean (Es Mayor de Edad): " + esMayorDeEdad);
        System.out.println("\n*** Clase envolvente, no es un tipo de dato primitivo ***");
        System.out.println("String (Nombre Completo): " + nombreCompleto);
    }
}