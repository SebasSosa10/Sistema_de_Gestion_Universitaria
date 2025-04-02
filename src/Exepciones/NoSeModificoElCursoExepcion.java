package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoSeModificoElCursoExepcion extends RuntimeException{
    
    public NoSeModificoElCursoExepcion(){
        super("no se modifico el curso");
    }
}
