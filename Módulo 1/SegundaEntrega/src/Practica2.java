/*Programa realizado por José Ángel Olmedo Guevara*/
import java.util.Scanner;
public class Practica2 {

    //Metodo estático, que me ayudará a realizar la búsqueda en el arreglo de objetos de tipo producto
    // Devuelve un objeto de tipo producto
    public static Producto buscarProducto(String codigo, Producto[] catalogo) {
        Producto productoEncontrado = null; // Por defecto será vacío
        int i = 0;

        // Bucle while para buscar el código, si coincide asigna el objeto al resultado y termina
        while (i < catalogo.length) {
            if (catalogo[i].getCodigo().equals(codigo)) {
                productoEncontrado = catalogo[i];
                i = catalogo.length; // Salida del ciclo ya que no se permite usar break :(
            } else {
                i++;
            }
        }

        return productoEncontrado;
    }

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        // Inicialización
        int cantidadProductos = 0;
        double subtotal = 0.0;
        final double IVA = 0.16; // 16%
        String codigoLeido;


        //Construcción de mi catálogo, un arreglo de tipo Producto que almacena objetos de tipo producto.
        Producto[] catalogo = new Producto[9];
        catalogo[0] = new Producto("1", "Cuaderno", 50.00);
        catalogo[1] = new Producto("3", "Pluma", 13.00);
        catalogo[2] = new Producto("5", "Regla", 16.50);
        catalogo[3] = new Producto("8", "Goma", 7.00);
        catalogo[4] = new Producto("9", "Lápiz", 7.50);
        catalogo[5] = new Producto("11", "Carpeta", 126.00);
        catalogo[6] = new Producto("22", "Tinta", 554.00);
        catalogo[7] = new Producto("99", "Sobres", 32.00);
        catalogo[8] = new Producto("123", "Folder", 5.00);



        System.out.println("\nTeclee los códigos de los productos de la venta.");

        do {
            System.out.printf("\nProducto (<Enter> para salir): ");
            codigoLeido = entrada.nextLine().trim(); // Lee la línea completa y quita espacios

            // Si la línea leída no está vacía, continua con la búsqueda y registro
            if (!codigoLeido.isEmpty()) {

                // Validación y Registro
                Producto productoVendido = buscarProducto(codigoLeido, catalogo);

                if (productoVendido != null) { //Si el producto existe
                    System.out.println(productoVendido.toString()); //Que lo despliege con un método que ya tengo

                    // Registro al total de productos que el cliente quiere comprar
                    cantidadProductos += 1; // Añadimos una unidad al total de productos
                    subtotal = subtotal + productoVendido.getPrecio();

                    // Mostramos el acumulado
                    System.out.printf("\t+ Lleva %d productos ($ %.2f antes del IVA)\n", cantidadProductos, subtotal);
                } else {
                    // Si el producto no existe, ya lo probé y no necesita manejo de excepciones
                    System.out.println("Producto INEXISTENTE"); //
                }
            }

        } while (!codigoLeido.isEmpty()); //Mientras que la línea no esté vacía.

        System.out.println("Fin de la venta");



        double ivaCalculado = subtotal * IVA;
        double total = subtotal + ivaCalculado;

        System.out.println("\nRESUMEN FINAL: "+ cantidadProductos+" productos");
        System.out.printf("Subtotal: $ %.2f\n", subtotal);
        System.out.printf("IVA (16%%): $ %.2f\n", ivaCalculado);
        System.out.printf("Total: $ %.2f\n", total);


        entrada.close();


    }
}
