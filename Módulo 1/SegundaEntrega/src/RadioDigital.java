public class RadioDigital extends Radio implements IControlesComunes{
    public String tipo;
    public int volumenActual;
    public boolean estatus;

    @Override
    public void subirVolumen(){ //Establecido en la interfaz
        this.volumenActual+=3;
        if(this.volumenActual > VOLUMENMAXIMO){ // Usa la constante de la interfaz
            this.volumenActual = VOLUMENMAXIMO;
        }
    }

    @Override
    public void bajarvolumen() {
        this.volumenActual-=3;
    }

    @Override
    public boolean encender() {
        this.estatus = true;
        return this.estatus;
    }

    @Override
    public boolean apagar() {
        this.estatus = false;
        return this.estatus;
    }

    /*@Override
    public int bajaVolumen() {  //Método que es abstract en la superclase
        this.volumen-=3;
        return this.volumen;
    }* ////El método no puede sobreescribirse porque fue 'final' en la clase padre (Radio)*/
}
