
package Exepciones;

/**
 *
 * @author JOAN
 */
public class EstudianteYaExisteEnElCursoExepcion extends Exception{
    
    public EstudianteYaExisteEnElCursoExepcion(){
        super("El Estudiante ya esta registrado en el curso");
    }
}
