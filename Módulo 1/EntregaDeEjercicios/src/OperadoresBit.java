public class OperadoresBit {
    public static void main(String [] args){

        System.out.println("\nOperadores a nivel de bit");
        System.out.println("Lógica de bits");
        int unaHamburguesa = 255;
        System.out.println(unaHamburguesa & 4); //

        int a = 5;  // En binario (8 bits): 00000101
        int b = 3;  // En binario (8 bits): 00000011
        int resultado;

        System.out.println("\n--- Ejemplos de Operadores a Nivel de Bit ---");
        System.out.println("Valor de A: " + a + " (Binario: 00000101)");
        System.out.println("Valor de B: " + b + " (Binario: 00000011)");
        System.out.println("-------------------------------------------------------");


        // 1. AND a nivel de bit (&)
        // Se pone 1 si AMBOS bits son 1.
        //   00000101 (5)
        // & 00000011 (3)
        // = 00000001
        resultado = a & b;
        System.out.println("\n1. Operador AND (&)");
        System.out.println("Resultado: " + resultado); // El resultado es 1
        System.out.println("Lógica binaria: Solo el último bit coincide (1 & 1 = 1)");


        // 2. OR a nivel de bit (|)
        // Se pone 1 si AL MENOS UN bit es 1.
        //   00000101 (5)
        // | 00000011 (3)
        // = 00000111
        resultado = a | b;
        System.out.println("\n2. Operador OR (|)");
        System.out.println("Resultado: " + resultado); // El resultado es 7
        System.out.println("Lógica binaria: 101 | 011 = 111");


        // 3. XOR a nivel de bit (^)
        // Se pone 1 si los bits son DIFERENTES.
        //   00000101 (5)
        // ^ 00000011 (3)
        // = 00000110
        resultado = a ^ b;
        System.out.println("\n3. Operador XOR (^)");
        System.out.println("Resultado: " + resultado); // El resultado es 6
        System.out.println("Lógica binaria: Solo el segundo y tercer bit son diferentes (1 ^ 0 = 1, 0 ^ 1 = 1)");


        // 4. NOT a nivel de bit (~)
        // Invierte todos los bits. En Java, los enteros son de 32 bits y usan complemento a dos.
        // ~5 resulta en -(5 + 1) = -6
        resultado = ~a;
        System.out.println("\n4. Operador NOT (~)");
        System.out.println("Resultado: " + resultado); // El resultado es -6
        System.out.println("Lógica binaria: Invierte todos los 32 bits, resultando en el negativo.");


        // 5. Desplazamiento a la izquierda (<<)
        // Desplaza los bits de 'a' dos posiciones a la izquierda. (Equivale a 5 * 2^2)
        // 00000101 << 2 = 00010100
        resultado = a << 2;
        System.out.println("\n5. Operador Desplazamiento Izquierda (<<)");
        System.out.println("Resultado: " + resultado); // El resultado es 20
        System.out.println("Lógica binaria: 00000101 se convierte en 00010100.");


        // 6. Desplazamiento a la derecha con signo (>>)
        // Desplaza los bits de 'a' una posición a la derecha. (Equivale a 5 / 2^1)
        // 00000101 >> 1 = 00000010
        resultado = a >> 1;
        System.out.println("\n6. Operador Desplazamiento Derecha con Signo (>>)");
        System.out.println("Resultado: " + resultado); // El resultado es 2
        System.out.println("Lógica binaria: 00000101 se convierte en 00000010.");

    }
}
