public /*abstract*/ class Persona implements ICrud{

    //Será la superclase para otras dos subclases
    //     padre/madre      hijos/hijas


    // Atributos
    private String nombre;
    private int edad;
    private char genero;

    //Métodos
    public Persona(){
        this.nombre = "Indefinido";
        this.genero ='F';
        this.edad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.length() > 2)
            this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad >= 0 && edad <= 150)
            this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        if(genero == 'F' || genero == 'M' ||  genero == 'D'){
            this.genero = genero;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", genero=" + genero +
                '}';
    }

    @Override
    public boolean create() {
        // INSERT INTO persona....
        return false;
    }

    @Override
    public int delete() {
        // UPDATE / DELETE
        return 0;
    }

    @Override
    public int update() {
        // UPDATE persona
        return 0;
    }

    @Override
    public boolean read() {
        // SELECT * FROM persona
        return false;
    }



}
