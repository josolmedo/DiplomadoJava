//Interfaz que deberán implementar todos nuestros dispositivos electrónicos

public interface IControlesComunes {

    // Atributos estáticos finales, solo se pueden estaticos finales ya que no se pueden instanciar
    public static final int VOLUMENMAXIMO = 100;



    // Métodos abstractos
    public abstract void subirVolumen();
    public abstract void bajarvolumen();
    public abstract boolean encender();
    public abstract boolean apagar();
}
