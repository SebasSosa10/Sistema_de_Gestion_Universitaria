package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoSePuedeEliminarCodigoNoExisteExepcion extends Exception{
    
    public NoSePuedeEliminarCodigoNoExisteExepcion(){
        super("No se encuentra registado ninguna persona con ese codigo");
    }
}
