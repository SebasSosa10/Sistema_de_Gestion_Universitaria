package Exepciones;

/**
 *
 * @author JOAN
 */
public class TieneQueExisterUnHorarioParaElEstudianteExepcion extends Exception {

    public TieneQueExisterUnHorarioParaElEstudianteExepcion() {
        super("No puede eliminar por que existe un estudiante dentro de ese curso");
    }

}
