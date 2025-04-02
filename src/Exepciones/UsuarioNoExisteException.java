package Exepciones;

/**
 *
 * @author JOAN
 */
public class UsuarioNoExisteException extends Exception {

    public UsuarioNoExisteException() {
        super("No existe un usuario con esta identificación");
    }
}
