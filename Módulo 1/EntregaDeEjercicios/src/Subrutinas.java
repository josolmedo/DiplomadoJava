public class Subrutinas {
    public static void hola(){
        int variable = 10;
        variable--;
        System.out.println("Hola");

    }
    public static void saluda (String persona){
        System.out.println("Buenas tardes "+persona);
    }

    public static void despedida(String nombre, int veces){
        for(int i=0; i<veces;i++){
            System.out.println("Hasta luego "+nombre);
        }
    }

    public static void tablaDeMultiplicar(int numero){
        System.out.println("\nTabla de multiplicar del numero "+numero+"\n");
        for(int i = 1; i < 11; i++){
            System.out.println(numero + " x "+ i + " = "+ (numero*i));
        }

    }

    public static void main(String[] args){
        System.out.println("\n----------Subrutinas----------");
        hola();
        hola();
        System.out.println("...más código...");
        hola();
        saluda("Angélica");
        saluda("José");


        despedida("Marco",2);
        tablaDeMultiplicar(5);
        tablaDeMultiplicar(7);
    }
}
