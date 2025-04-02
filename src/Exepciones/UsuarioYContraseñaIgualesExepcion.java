package Exepciones;

/**
 *
 * @author JOAN
 */
public class UsuarioYContraseñaIgualesExepcion extends Exception{
    
    public UsuarioYContraseñaIgualesExepcion(){
        super("El usuario y la contraseña son iguales");
    }
    
}
