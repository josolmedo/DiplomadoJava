public class Herencia {
    public static void main(String[] args) {
        System.out.println("\nHerencia");

        //Creación de objetos de la superclase Persona

        /*Persona o1 = new Persona();
        o1.setNombre("Marco");
        o1.setEdad(-100);
        System.out.println(o1);
        o1.setEdad(90);
        o1.setNombre("Isaac");
        System.out.println(o1);*/

        // Paciente
        Paciente o2 = new Paciente();
        System.out.println(o2.toString());


        //Médico
        Medico o3 = new Medico();
        System.out.println(o3);
        o3.setNombre("Dr. Lopez");  //setNombre fue definido en Persona
        o3.setEspecialidad("Geriatria");   //setEspecialidad fue definido en Médico
        o3.setEdad(50);    //Utiliza setEdad de Médico
        System.out.println(o3);
    }
}
