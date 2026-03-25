public class CuentaBancaria {
    //Atributos(titular, numero, saldo)
    private String titular;
    private int numero;
    private double saldo;


    //Métodos
    public CuentaBancaria(){
        System.out.println("******Estoy creando una cuenta bancaria******");
    }

    public CuentaBancaria(String titular, int numero, double saldo){
        System.out.println("\n***Creando cuenta bancaria***");
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }


    /*public void setSaldo(double nuevoSaldo){
    *   this.saldo = nuevoSaldo;
    * }*/

    public double getSaldo(){
        return this.saldo;
    }

    public void setNumero(int nuevoNumero){
        if(nuevoNumero >= 10000) //De 5 dígitos
            this.numero = nuevoNumero;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setTitular(String nuevoTitular){
        if (nuevoTitular.length() >= 5) //Si el nombre tiene al menos 5 caracteres, lo cambia.
            this.titular = nuevoTitular;
    }

    public String getTitular(){
        return this.titular;
    }


    public boolean depositar(double cantidad){
        boolean resultado = false;
        if(cantidad > 0){
            this.saldo = this.saldo + cantidad;
            // Acceso a las bases de datos para afectar el saldo
            resultado = true;
        }
        return resultado;
    }

    public boolean retirar(double cantidad){
        boolean resultado = false;
        if(cantidad > 0 && cantidad <= this.saldo){
            this.saldo = this.saldo - cantidad;
            // Acceso a las bases de datos para afectar el saldo
            resultado = true;
        }
        return resultado;
    }

    public boolean transferir(CuentaBancaria destino, double monto){

        boolean resultado = false;
        if(this.retirar (monto) && destino.depositar(monto)){
            resultado = true; // Cuando pudo retirar del origen y depositar en el destino
        }
        monto = monto *110;
        return resultado;
    }

    public String toString(){


        return this.titular + " ("+this.numero+"). $"+this.saldo;
    }






}
