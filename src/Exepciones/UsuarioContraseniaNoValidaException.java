package Exepciones;

/**
 *
 * @author JOAN
 */
public class UsuarioContraseniaNoValidaException extends Exception{
    
    public UsuarioContraseniaNoValidaException(){
        super("No existe un usuario y una contraseña con esta identificación");
    }
}
