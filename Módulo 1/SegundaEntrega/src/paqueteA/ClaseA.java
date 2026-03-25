package paqueteA;

public class ClaseA {
    public int aPublico = 1;
    private int aPrivado = 2;
    protected int aProtegido = 3;
    int aLibre = 4;

    public void metodo(){
        aPublico = 11;
        aPrivado = 22;
        aProtegido = 33;
        aLibre = 44;
    }
}
