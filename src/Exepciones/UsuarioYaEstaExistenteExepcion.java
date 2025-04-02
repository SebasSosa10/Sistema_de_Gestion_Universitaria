package Exepciones;

/**
 *
 * @author JOAN
 */
public class UsuarioYaEstaExistenteExepcion extends Exception{
    
    public UsuarioYaEstaExistenteExepcion(){
        super("El usuario ya lo tiene otra persona");
    }
}
