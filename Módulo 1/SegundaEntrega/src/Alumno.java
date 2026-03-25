import java.util.Objects;

public class Alumno {
    private String nombre;
    private String matricula;
    private String carrera;

    public Alumno(String nombre, String matricula, String carrera) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Alumno alumno)) return false;
        return Objects.equals(matricula, alumno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }

    public int compareTo(Alumno otroAlumno){
        // Queremos hacer una comparación por valor numérico, no de String

        long numero1 = Long.parseLong(this.getMatricula());
        long numero2 = Long.parseLong(otroAlumno.getMatricula());
        int regreso = 0; // Son iguales por default

        if(numero1 > numero2){
            regreso = 1; // this > otroAlumno
        }
        else{
            if (numero1 < numero2){
                regreso = -1; // this < otroAlumno
            }
        }
        return regreso;

        // return this.getMatricula().compareTo(otroAlumno.getMatricula());

    }
}
