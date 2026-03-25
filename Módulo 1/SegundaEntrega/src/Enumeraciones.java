enum Estatus {CONFIRMADO, ARMADO, ENVIADO, RECIBIDO};
enum Modulos {FUNDAMENTOS, BDD, PATRONES, SPRING, SEGURIDAD};


public class Enumeraciones {
    public static void main(String[] args){
        enum Valores{BAJOPESO, PESOIDEAL, SOBREPESO, OBESIDAD};
        System.out.println("\n-------------------Enumeraciones-------------------");
        Estatus objeto = Estatus.CONFIRMADO;
        System.out.println("\nTu pedido está en "+objeto);
        //  .....

        objeto = Estatus.ARMADO;
        System.out.println("\nAhora tu pedido está en "+objeto);

        // ......
        objeto = Estatus.RECIBIDO;
        System.out.println("\nAhora tu pedido está en "+objeto);

        Nivel nivelJose = Nivel.ORO;
        System.out.println("\nNivel de José: "+nivelJose);
        System.out.println("\tDebe pagar anualmente: $"+nivelJose.getAnualidad());
        System.out.println("\tSus compras tienen el descuento de " + nivelJose.getDescuento() + "%");


    }
}
