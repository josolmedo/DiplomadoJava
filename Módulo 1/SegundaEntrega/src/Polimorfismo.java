public class Polimorfismo {
    public static void main(String[] args){
        System.out.println("\n----------Polimorfismo----------");

        Persona objeto1 = new Persona();
        Paciente objeto2 = new Paciente();
        Medico objeto3 = new Medico();

        Persona[] grupo = new Persona[4];

        grupo[0] = objeto1; //Persona
        grupo[1] = objeto2; //Paciente
        grupo[2] = objeto3; //Médico
        grupo[3] = new Paciente();  //Paciente

        for(int i = 0; i<4; i++){
            System.out.println("Elemento " + i + " = " + grupo[i].getNombre());
        }

        // Medico objetoM = new Persona();  //ERROR
        Persona objetoP = new Medico(); //OK
        // SuperClase objeto = new Subclase();


    }
}
