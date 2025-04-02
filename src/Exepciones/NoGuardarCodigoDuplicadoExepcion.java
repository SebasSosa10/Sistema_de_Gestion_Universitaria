package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoGuardarCodigoDuplicadoExepcion extends Exception{
    
    public NoGuardarCodigoDuplicadoExepcion(){
        super("La persona con este codigo ya existe");
    }
    
}
