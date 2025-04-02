package Exepciones;

/**
 *
 * @author JOAN
 */
public class PorcentajeNoCompletaElTotalExepcion extends Exception{

    public PorcentajeNoCompletaElTotalExepcion() {
        super("El porcentaje total no suma 100%");
    }
    
}
