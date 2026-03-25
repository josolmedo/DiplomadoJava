public final class Paciente extends Persona{
    //       subclase         superclase
    //       hija             madre


    // Atributos
    private String expediente;
    private String padecimiento;

    // Métodos
    public Paciente(){
        this.expediente = "abc001/20";
        this.padecimiento = "Desconocido";
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    @Override
    public String toString() {
        return getNombre() +" ("+ getGenero()+").)"+getEdad() + " años "+
                "expediente='" + expediente + '\'' +
                ", padecimiento='" + padecimiento + '\'' +
                '}';
    }

    public static String listaDePacientes(){
        // "EJECUTAMOS" un SELECT nombre FROM tablaPacientes en la BD.
        return "José\nMarco\nFernanda\nIsaac\nAngélica";
    }

    @Override
    public boolean create() {
        // INSERT INTO pacientes....
        return false;
    }

    @Override
    public int delete() {
        // UPDATE / DELETE
        return 0;
    }

    @Override
    public int update() {
        // UPDATE pacientes
        return 0;
    }

    @Override
    public boolean read() {
        // SELECT * FROM pacientes
        return false;
    }


}
