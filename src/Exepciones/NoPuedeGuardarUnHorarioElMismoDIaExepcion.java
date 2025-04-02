
package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoPuedeGuardarUnHorarioElMismoDIaExepcion extends Exception{
    
    public NoPuedeGuardarUnHorarioElMismoDIaExepcion(){
        super("No puede crear un horario el mismo dia");
    }
}
