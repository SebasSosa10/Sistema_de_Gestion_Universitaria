package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoPuedePonerElHorarioSeCruzaExepcion extends Exception{
    
    public NoPuedePonerElHorarioSeCruzaExepcion(){
        super("No puede poner horario en esa franja por que se cruzan");
    }
}
