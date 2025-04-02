package Exepciones;

/**
 *
 * @author JOAN
 */
public class NoSePuedeModificarPorElEstudianteExepcion extends Exception{
    
    public NoSePuedeModificarPorElEstudianteExepcion(){
        super("El Horario se cruza con un estudiante");
    }
}
