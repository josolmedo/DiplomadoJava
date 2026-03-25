public class PruebaCuentaBancaria {
    public static void main(String [] args){
        System.out.println("Prueba de la cuenta bancaria");
        //Instanciar a CuentaBancaria
        //Clase objeto = new Clase();

        CuentaBancaria objeto1 = new CuentaBancaria("José Olmedo", 55123, 1000);

        /*// Para tener acceso a un atributo público a un objeto
        //Objeto.atributo
        objeto1.setTitular("José Olmedo");
        objeto1.setNumero(55123);
        objeto1.setSaldo(1000); //Agrego dinero desde un inicio*/

        //Para ejecutar un método de un objeto
        //objeto.metodo (parámetros de entrada)

        /* Depósito */

        System.out.println("\nSaldo inicial: "+objeto1.getSaldo()+" pesos.");
        if(objeto1.depositar(-300))
            System.out.println("Saldo actualizado: "+objeto1.getSaldo()+" pesos.");
        else
            System.out.println("Operación rechazada");

        /* RETIRO */

        System.out.println("\nSaldo inicial: "+objeto1.getSaldo()+" pesos.");
        if(objeto1.retirar(300))
            System.out.println("Saldo actualizado: "+objeto1.getSaldo()+" pesos.");
        else
            System.out.println("Operación rechazada");

        /* CONSULTA */

        System.out.println("\nTu saldo es de: "+ objeto1.getSaldo()+ " pesos");


    }
}
