package Exepciones;

/**
 *
 * @author JOAN
 */
public class NotaMayorExepcion extends RuntimeException{

    public NotaMayorExepcion() {
        super("La nota es mayor a 5");
    }
}
