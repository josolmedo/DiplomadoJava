public class Funciones {

    public static int siempre10(){
        return 10;
    }

    public static double suma(int numero1, int numero2){
        double resultado = 0;
        resultado = numero1 + numero2;
        return resultado;
    }

    public static int sumatoria(int numero1, int veces){
        int resultado = 0;
        for(int i = 0; i < veces; i++){
            resultado = resultado + numero1;
        }
        return resultado;
    }

    public static String nombreMes(int m) {

        String[] meses = {
                "Mes no usado", // Posición 0: Ignorada o usada para valor por defecto.
                "Enero",        // Posición 1
                "Febrero",      // Posición 2
                "Marzo",        // Posición 3
                "Abril",        // Posición 4
                "Mayo",         // Posición 5
                "Junio",        // Posición 6
                "Julio",        // Posición 7
                "Agosto",       // Posición 8
                "Septiembre",   // Posición 9
                "Octubre",      // Posición 10
                "Noviembre",    // Posición 11
                "Diciembre"     // Posición 12
        };

        // Verificamos que el número del mes (m) esté dentro del rango válido [1, 12].
        if (m >= 1 && m <= 12) {
            return meses[m];
        } else {
            // Si el número no es válido, devolvemos un mensaje de error.
            return "Mes inválido";
        }
    }

    public static void main(String[] args){

        System.out.println("Funciones");
        System.out.println(siempre10());
        int variable = siempre10();
        System.out.println(variable);

        System.out.println("Resultado de llamar a suma(a,b) "+ suma(5,4));
        System.out.println("Resultado de sumar 5, 5 veces: "+ sumatoria(5,5));
        System.out.println(nombreMes(8));
    }
}
