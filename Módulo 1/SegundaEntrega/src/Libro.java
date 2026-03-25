import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private int edicion;

    public Libro(){

    }

    public Libro(String titulo, int edicion, String autor) {
        this.titulo = titulo;
        this.edicion = edicion;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", edicion=" + edicion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        Libro libro = (Libro) o; // casting (convierto otro --> Libro)
        return Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor);  //Quitamos la edición
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor); //Quitamos la edición
    }

    public int compareTo(Libro otroLibro){
        //Un libro está antes que otro si el nombre es alfabéticamente menor que el otro,
        // Y que la edición sea menor (en caso de que los títulos sean iguales)
        int regreso = this.getTitulo().compareTo(otroLibro.getTitulo());
        if(regreso == 0){ // Son iguales los títulos
            if(this.getEdicion() > otroLibro.getEdicion()){
                regreso = 1;
            }
            else{
                regreso = -1;
            }
        }

        return regreso;
    }

}

