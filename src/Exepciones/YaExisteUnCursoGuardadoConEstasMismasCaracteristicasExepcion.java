package Exepciones;

/**
 *
 * @author JOAN
 */
public class YaExisteUnCursoGuardadoConEstasMismasCaracteristicasExepcion extends Exception{

    public YaExisteUnCursoGuardadoConEstasMismasCaracteristicasExepcion() {
        super("Ya existe un curso con las mismas caracteristicas");
    }
}
