package Exepciones;

/**
 *
 * @author JOAN
 */
public class ReservaNoExisteExepcion extends Exception {

    public ReservaNoExisteExepcion() {
        super("La reserva no existe");
    }

}
