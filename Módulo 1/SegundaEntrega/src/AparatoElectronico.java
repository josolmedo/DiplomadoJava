public abstract class AparatoElectronico {
    public boolean prendido;
    public int volumen;
    public final int VOLUMEN_MAXIMO = 100;
    public static int instancias = 0;
    public static int contador = 0;

    public AparatoElectronico(){
        contador++;
    }

    public int subeVolumen(){
        this.volumen++;
        if(this.volumen > VOLUMEN_MAXIMO) {
            this.volumen = VOLUMEN_MAXIMO;
        }
        return this.volumen;
    }

    public abstract int bajaVolumen();
    public abstract boolean encender();
    public static void mensaje(){
        System.out.println("Mensaje desde método estático: "+contador);
    }
}
//Las clases abstractas no se pueden instanciar pero si puedo heredar
//Las clases finales no pueden heredar pero si instanciar