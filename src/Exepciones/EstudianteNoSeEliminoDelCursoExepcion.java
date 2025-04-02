
package Exepciones;

/**
 *
 * @author JOAN
 */
public class EstudianteNoSeEliminoDelCursoExepcion extends Exception{
    
    public EstudianteNoSeEliminoDelCursoExepcion(){
        super("El estudiante no se pudo eliminar del curso");
    }  
}
