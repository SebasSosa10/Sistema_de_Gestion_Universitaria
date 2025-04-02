package Exepciones;

/**
 *
 * @author JOAN
 */
public class ReservaPuestoExepcion extends Exception{

    public ReservaPuestoExepcion() {
        super("El puesto tiene una reserva activa");
    }
    
    
}
