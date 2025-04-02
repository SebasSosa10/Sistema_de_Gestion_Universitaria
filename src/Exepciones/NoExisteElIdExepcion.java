package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoExisteElIdExepcion extends Exception {

    public NoExisteElIdExepcion() {
        super("El id no es de un estudiante");
    }

}
