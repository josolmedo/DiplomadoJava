public class Sobrecarga {

    public static double suma (int parametro){
        return parametro+1;
    }

    public static String suma(String texto1, String texto2){
        return texto1+texto2;
    }

    public static double suma (int primerP, int segundoP){
        double resultado = 0;
        resultado = primerP + segundoP;
        return resultado;
    }
//La sobrecarga permite la definición de dos o más métodos con el mismo nombre
    public static double suma (double primerP, double segundoP){
        double resultado = 0;
        resultado = primerP + segundoP;
        return resultado;
    }

    public static void main(String[] args){
        System.out.println("Sobrecarga de métodos (funciones/procedimientos)");

        System.out.println("Suma de enteros: "+suma(9,2));
        System.out.println("Suma de dobles: "+suma(9.5,2.4));
        System.out.println("Suma de UN entero: "+ suma(9));
        System.out.println(suma(4,9));
        System.out.println(suma(4,'9'));
        // int [promoción]
        System.out.println(suma(4.5,9)); //suma(double, double)
        System.out.println(suma(4.5,'9')); //double, char
        System.out.println(suma("Hola"," Mundo"));

        //System.out.println() Es un método con 10 sobrecargas

    }
}
