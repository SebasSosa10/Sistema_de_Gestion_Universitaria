package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoSeRegistroElHorarioExepcion extends Exception{
    
    public NoSeRegistroElHorarioExepcion(){
        super("el Horario no fue Registrado");
    }
}
