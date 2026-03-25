package paqueteA;

public class SubClaseA extends ClaseA{
    public void metodo(){
        aPublico = 1111;
        // aPrivado = 2222; No tiene acceso a lo privado de la Superclase
        aProtegido = 3333;
        aLibre = 4444;
    }
}
