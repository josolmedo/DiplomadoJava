public class Personaje {

    //  Atributos
    private String nombre;
    private int vida;
    private boolean escogido;
    private boolean vivo;
    private int fuerza;


    // Métodos



    /// Constructor(es)
    public Personaje(){
        //Valores por defecto cuando se ejecute un new Personaje()
        this.nombre = "N";
        this.vida = 100;
        this.escogido = false;
        this.vivo = true;
        this.fuerza = 1;
    }

    public Personaje(int id){
        // Se ejecuta al tener un new Persona (#)
        this();  //Personaje();
        // SIMULACIÓN de la extracción de datos en una BDD
        switch (id){
            case 1:
                this.nombre = "Goku";
                this.fuerza = 7;
                break;
            case 2:
                this.nombre = "Vegeta";
                this.fuerza = 6;
                break;
            case 3:
                this.nombre = "Gohan";
                this.fuerza = 6;
                break;
            case 4:
                this.nombre = "Broly";
                this.fuerza = 8;
                break;
        }
    }



    /// Setters y Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if(this.vida <= 0){
            setVivo(false);
        }
    }

    public boolean isEscogido() {
        return escogido;
    }

    public void setEscogido(boolean escogido) {
        this.escogido = escogido;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    /// golpear()
    public void golpear(Personaje oponente){
        oponente.setVida(oponente.getVida() - this.getFuerza());
    }


    ///  patear()
    public void patear(Personaje oponente){
        oponente.setVida(oponente.getVida() - this.getFuerza());
    }



    /// toString()
    @Override
    public String toString() {
        return getNombre().toUpperCase() + " ["+ getVida() + "]";
    }
}
