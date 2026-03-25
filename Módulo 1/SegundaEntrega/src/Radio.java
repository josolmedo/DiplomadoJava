public class Radio extends AparatoElectronico{

    public boolean encendido = false;

    @Override
    public final int bajaVolumen() {  //Método que es abstract en la superclase
        this.volumen--;
        return this.volumen;
    }

    @Override
    public boolean encender() {
        this.encendido = true;
        return encendido;
    }

    public static int existencias (){
        //SELECT COUNT (*) FROM existencias WHERE tipo = 'Radio';
        return 10;
    }
}
