public class FinalAbstract {
    public static void main(String[] args){
        System.out.println("abstract");

        //Métodos y clases abstract
        Radio.mensaje();
        Radio objeto = new Radio();
        Radio.mensaje();
        objeto.subeVolumen();

        System.out.println("final");
        double precio = 10;
        precio = precio * 1.13;
        System.out.println(precio);

        final double IVA = .16;
        System.out.println("IVA de "+IVA);


        objeto.bajaVolumen();

        //static
        System.out.println("\nInstancias= "+objeto.instancias);
        objeto.instancias=123;
        System.out.println("Instancias= "+objeto.instancias);

        Radio nuevo = new Radio();
        System.out.println("\nInstancias= "+nuevo.instancias);
        nuevo.instancias=856;

        System.out.println("\nInstancias= "+objeto.instancias);
        System.out.println("\nInstancias= "+nuevo.instancias);
        System.out.println("\nInstancias de Radio= "+Radio.instancias);
        //Un atributo estatico le pertenece a la clase, 1 por clase.
        //Un atributo que no tiene 'static' tiene 1 por objeto.
        Radio.mensaje();

        RadioDigital rd = new RadioDigital();
        Radio.mensaje();
        System.out.println("Pacientes registrados\n\n"+Paciente.listaDePacientes());

    }
}
/*Final se puede utilizar a nivel de variable(atributo), clase y método. Cuando se use ya no se puede
cambiar de valor, se espera que los nombres tengan MAYÚSCULAS
FINAL como método también significa inmutable, pero significa que no se puede sobreescribir en una clase
hereda de ella.
FINAL como clase, ya no puedes heredar de ella.*/