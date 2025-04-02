package Exepciones;

/**
 *
 * @author JOAN
 */
public class ElEstudianteNoHaSidoRegistrdoaUnCursoExepcion extends Exception{

    public ElEstudianteNoHaSidoRegistrdoaUnCursoExepcion() {
        super("Todavia no ha sido asignado el curso");
    }
    
    
}
