package Exepciones;

/**
 *
 * @author JOAN
 */
public class ContrasenaIgualLaTemporalExepcion extends Exception{
    
    public ContrasenaIgualLaTemporalExepcion(){
        super("La contraseña es igual a la temporal");
    }
}
