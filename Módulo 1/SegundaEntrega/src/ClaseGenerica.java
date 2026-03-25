public class ClaseGenerica <T>{
    // El parámetro T SIEMPRE debe ser una clase
    public String nombre;
    public double promedio;
    public T edad;

    public ClaseGenerica(){
        this.nombre = "Desconocido";
        this.promedio = 5;
        // this.edad = 18; Ya no es posible asignar un int a edad

    }

    public void imprime(T objeto){
        System.out.println("En edad tengo: "+this.edad);
        System.out.println("Y también imprimo: "+objeto);
    }

    @Override
    public String toString() {
        return "ClaseGenerica{" +
                "nombre='" + nombre + '\'' +
                ", promedio=" + promedio +
                ", edad=" + edad +
                '}';
    }
}
