public class Medico extends Persona{
    // Atributos
    private String especialidad;
    private double precioConsulta;

    public Medico(){
        this.especialidad = "Medicina general";
        this.precioConsulta = 100;
    }


    //Metodos

    /*@Override
    public setEdad*/

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getPrecioConsulta() {
        return precioConsulta;
    }

    public void setPrecioConsulta(double precioConsulta) {
        this.precioConsulta = precioConsulta;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "especialidad='" + especialidad + '\'' +
                ", precioConsulta=" + precioConsulta +
                '}';
    }

    @Override
    public boolean create() {
        // INSERT INTO personalMedico....
        return false;
    }

    @Override
    public int delete() {
        // UPDATE / DELETE
        return 0;
    }

    @Override
    public int update() {
        // UPDATE personalMedico
        return 0;
    }

    @Override
    public boolean read() {
        // SELECT * FROM personalMedico
        return false;
    }



}
