package Exepciones;

/**
 *
 * @author JOAN
 */
public class PorcentajeExcedeElTotalExepcion extends Exception{

    public PorcentajeExcedeElTotalExepcion() {
        super("El porcentaje que vas a poner excede el 100%");
    }
}
