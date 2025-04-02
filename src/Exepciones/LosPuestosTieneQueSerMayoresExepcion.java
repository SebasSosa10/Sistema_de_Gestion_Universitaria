package Exepciones;

/**
 *
 * @author JOAN
 */
public class LosPuestosTieneQueSerMayoresExepcion extends Exception{

    public LosPuestosTieneQueSerMayoresExepcion() {
        super("Los puestos tienen que ser mayor a 1");
    }   
}
