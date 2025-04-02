package modelo;

import Util.IList;
import Util.Lista;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author JOAN
 */
public class Programa implements Serializable {

    private String nombre;
    private String codigo;
    private IList<Materia> listaMateria;

    public Programa(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.listaMateria = new Lista<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public IList<Materia> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(IList<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public void agregarMateria(Materia materia){
        this.listaMateria.add(materia);
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " " + this.getCodigo();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programa other = (Programa) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    
}
