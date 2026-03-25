import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {

    public static String nombreDeMes(int numero){

        String[] meses = {
                "Enero",
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Septiembre",
                "Octubre",
                "Noviembre",
                "Diciembre"
        };
        try{
            return "El número corresponde al mes: "+meses[numero-1];

        } catch (Exception e) {
            System.out.println("Ingresaste un número que no corresponde a ningún mes");
            System.out.println(e.getMessage());
        }
        return "El número corresponde al mes: "+meses[numero-1];

    }

    public static void metodo(int numero){
        int algo = 100/numero;

    }

    public static void main(String[] args){
        System.out.println("Detección y manejo de excepciones");
        int numerador = 10;
        int denominador = 0;
        double resultado;
        Scanner teclado = new Scanner(System.in);

        try{

            System.out.print("Dame un número: ");
            denominador = teclado.nextInt();
            metodo(denominador);

            String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};


            resultado = numerador/denominador;
            System.out.println("\n");
            System.out.println(numerador+"/"+denominador+" = "+resultado);
            System.out.println(dias[denominador]);
            System.out.println(nombreDeMes(denominador));
        }
        catch(ArithmeticException e){
            System.out.println("\nError, no es posible dividir por cero");
            System.out.println(e.getMessage());
        }
        catch(IndexOutOfBoundsException a){
            System.out.println("Ese día ("+denominador+") no existe.");
            System.out.println("Trataste de exceder a un elemento de un arreglo con un índice que no existe");
            System.out.println(a.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("Solo debes dar números enteros");
            System.out.println(e.getMessage());

        }
        catch(Exception e){
            System.out.println("Algo salió mal, ingresaste un dígito mal");
            System.out.println(e.getMessage());
        }

        teclado.close();

    }
}
