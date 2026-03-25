public class Television extends AparatoElectronico implements IControlesComunes, ICrud{
    public boolean encendido;
    public double volumen;
    public double canal;

    @Override
    public void subirVolumen(){ //Establecido en la interfaz
        this.volumen+=2;
    }

    public void subirVolumen(double cuanto){
        this.volumen += cuanto;
        if(this.volumen > VOLUMENMAXIMO){
            this.volumen = VOLUMENMAXIMO;
        }
    }

    @Override
    public void bajarvolumen() {
        this.volumen-=2;
    }

    public int bajaVolumen(){ //Establecido en esta clase.
        this.volumen-=2;
        return 10;
    }

    @Override
    public boolean encender() {
        this.encendido = true;
        return this.encendido;
    }

    @Override
    public boolean apagar() {
        this.encendido = false;
        return this.encendido;
    }

    @Override
    public boolean create() {
        // INSERT INTO televisiones....
        return false;
    }

    @Override
    public int delete() {
        // UPDATE / DELETE
        return 0;
    }

    @Override
    public int update() {
        // UPDATE televisiones
        return 0;
    }

    @Override
    public boolean read() {
        // SELECT * FROM televisiones
        return false;
    }
}
