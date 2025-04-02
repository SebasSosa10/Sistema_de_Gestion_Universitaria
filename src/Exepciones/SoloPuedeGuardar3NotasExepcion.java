package Exepciones;

/**
 *
 * @author JOAN
 */
public class SoloPuedeGuardar3NotasExepcion extends Exception{

    public SoloPuedeGuardar3NotasExepcion() {
        super("Solo puedes guardar 3 notas");
    }
    
    
}
