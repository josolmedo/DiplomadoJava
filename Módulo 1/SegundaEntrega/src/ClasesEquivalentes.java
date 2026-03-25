public class ClasesEquivalentes {
    public static void main(String[] args){
        System.out.println("Clases equivalentes");
        double variableDouble = 10.5;
        Double objetoDouble = 9.43;

        variableDouble =3.23;
        objetoDouble =4.2;

        System.out.println(variableDouble+ " -- "+ objetoDouble);
        System.out.println(variableDouble+objetoDouble);

        objetoDouble = variableDouble;
        System.out.println(variableDouble+ " -- "+ objetoDouble);

        objetoDouble = 98.345;
        variableDouble=objetoDouble;
        System.out.println(variableDouble+ " -- "+ objetoDouble);


        variableDouble = Double.parseDouble("9876.31"); // Método estático de la clase Double
        System.out.println(Integer.MAX_VALUE); // Atributo estático final de la clase Integer
        System.out.println(Byte.MAX_VALUE +" --- "+Byte.MIN_VALUE);


    }
}
