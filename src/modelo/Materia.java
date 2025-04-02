package modelo;

import java.io.Serializable;

/**
 *
 * @author JOAN
 */
public class Materia implements Serializable {
    private String nombreMateria;
    private String codigo;

    public Materia(String nombreMateria, String codigo) {
        this.nombreMateria = nombreMateria;
        this.codigo = codigo;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return this.getNombreMateria()+ " " + this.getCodigo();
    }
}
