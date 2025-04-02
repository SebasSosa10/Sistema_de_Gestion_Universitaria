package Exepciones;

/**
 *
 * @author JOAN
 */
public class ElEstudianteNoesDeEsteProgramaExepcion extends Exception{
    
    public ElEstudianteNoesDeEsteProgramaExepcion(){
        super("No es del mismo programa el estudiante con el curso");
    }
    
}
