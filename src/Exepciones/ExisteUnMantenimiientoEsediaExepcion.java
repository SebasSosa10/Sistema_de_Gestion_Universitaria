package Exepciones;

/**
 *
 * @author JOAN
 */
public class ExisteUnMantenimiientoEsediaExepcion extends Exception {

    public ExisteUnMantenimiientoEsediaExepcion() {
        super("ese dia el laboratorio estara en mantenimiento");
    }

}
