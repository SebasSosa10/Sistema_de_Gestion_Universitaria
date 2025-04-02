package Exepciones;

/**
 *
 * @author JOAN
 */
public class SoloPuedeHaberUnCursoConEsaJornadaExepcion extends Exception{

    public SoloPuedeHaberUnCursoConEsaJornadaExepcion() {
        super("Solo puede tener un mismo curso en diferente jornada");
    }
    
    
    
}
