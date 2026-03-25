package paqueteA;

public class Instanciacion {
    public static void main(String[] args){
        ClaseA objetoA = new ClaseA();
        objetoA.aPublico = 111;
        // objetoA.aPrivado = 222; La instancia no tiene acceso a lo privado
        objetoA.aProtegido = 333;
        objetoA.aLibre = 444;

        SubClaseA hijoA = new SubClaseA();
        hijoA.aPublico = 11111;
        //hijo.aPrivado = 22222;  La instancia no tiene acceso a lo privado
        hijoA.aProtegido = 33333;
        hijoA.aLibre = 44444;


    }
}
