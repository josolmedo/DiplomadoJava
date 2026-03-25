package paqueteB;

import paqueteA.ClaseA; //Parecido a java.util.Scanner

public class Instanciacion {
    public void metodo(){
        ClaseA objeto = new ClaseA();
        objeto.aPublico = -111; //Solo tengo acceso a lo publico
    }
}
