package Exepciones;

/**
 *
 * @author JOAN
 */
public class UsuarioIgualAlTemporalExepcion extends Exception{
    
    public UsuarioIgualAlTemporalExepcion(){
        super("El usuario es igual al temporal");
    }
}
