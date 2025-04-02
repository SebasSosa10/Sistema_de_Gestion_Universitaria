package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoSeGuardoElCursoExepcion extends RuntimeException{
    
    public NoSeGuardoElCursoExepcion(){
        super("El curso no se guardo adecuadamente");
    }
}
