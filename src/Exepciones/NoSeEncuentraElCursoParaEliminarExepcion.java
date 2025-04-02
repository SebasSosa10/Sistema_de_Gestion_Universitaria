package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoSeEncuentraElCursoParaEliminarExepcion extends RuntimeException{
    
    public NoSeEncuentraElCursoParaEliminarExepcion(){
        super("el curso al que vas a eliminar no se encuentra registrado");
    }
    
}
