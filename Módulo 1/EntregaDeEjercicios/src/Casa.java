public class Casa {

    // Atributos (Características o variables de la clase)
    String color;
    int numPisos;
    double areaMetrosCuadrados;
    boolean tieneJardin;

    // Constructor: Método especial para crear e inicializar objetos.
    // Este constructor permite crear una casa y definir sus características iniciales.
    public Casa(String colorInicial, int pisosIniciales, double area) {
        this.color = colorInicial;
        this.numPisos = pisosIniciales;
        this.areaMetrosCuadrados = area;
        this.tieneJardin = false; // Valor por defecto
    }

    // Métodos (Comportamientos o funciones de la clase)

    // Método que no devuelve valor (procedimiento) y no tiene parámetros.
    public void mostrarEstado() {
        System.out.println("--- Estado Actual de la Casa ---");
        System.out.println("Color: " + color);
        System.out.println("Pisos: " + numPisos);
        System.out.println("Área: " + areaMetrosCuadrados + " m²");

        // Uso de ternario para simplificar la salida
        String estadoJardin = tieneJardin ? "Sí tiene" : "No tiene";
        System.out.println("Jardín: " + estadoJardin);
    }

    // Método que recibe parámetros y modifica un atributo (setter).
    public void pintarCasa(String nuevoColor) {
        System.out.println("-> Pintando la casa de " + color + " a " + nuevoColor + "...");
        this.color = nuevoColor;
        System.out.println("-> La casa ahora es de color " + color + ".");
    }

    // Método que devuelve un valor (función) y recibe parámetros.
    public double calcularCostoPintura(double costoPorMetro) {
        // Retorna el costo total de pintura basado en el área de la casa.
        return this.areaMetrosCuadrados * costoPorMetro;
    }
}