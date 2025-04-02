package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoSePuedeModificarCodigoExepcion extends Exception{
    
    public NoSePuedeModificarCodigoExepcion(){
        super("No se puede modificar el codigo");
    }
}
