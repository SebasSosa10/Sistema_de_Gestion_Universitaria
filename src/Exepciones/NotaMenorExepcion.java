package Exepciones;

/**
 *
 * @author JOAN
 */
public class NotaMenorExepcion  extends RuntimeException{

    public NotaMenorExepcion() {
        super("La nota es menor a 0");
    }
    
    
}
