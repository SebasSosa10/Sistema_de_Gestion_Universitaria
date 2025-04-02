package Exepciones;

/**
 *
 * @author JOAN
 */
public class ContraseñaNoValidaException extends Exception {

    public ContraseñaNoValidaException() {
        super("La contraseña no es valida");
    }
}
