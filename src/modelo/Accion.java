package modelo;

/**
 *
 * @author JOAN
 */
public class Accion <T> {
    
    private String accion;
    private Object objeto;

    public Accion(String accion, Object objeto) {
        this.accion = accion;
        this.objeto = objeto;
    }

    public String getAccion() {
        return accion;
    }
    
    public Object getObjeto() {
        return objeto;
    }
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}
