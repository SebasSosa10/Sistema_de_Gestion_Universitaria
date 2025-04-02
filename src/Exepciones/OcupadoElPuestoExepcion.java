package Exepciones;

/**
 *
 * @author JOAN
 */
public class OcupadoElPuestoExepcion extends Exception{

    public OcupadoElPuestoExepcion() {
        super("solo puede a ver un prestamo por puesto");
    }
    
}
