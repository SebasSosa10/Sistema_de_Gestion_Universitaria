package modelo;

import Util.IList;
import Util.Lista;
import java.io.Serializable;

/**
 *
 * @author JOAN
 */
public class Nota implements Serializable {

    private String descripcion;
    private double porcenta;
    private IList<DetalleNota> listaDetalle;

    public Nota(String descripcion, double porcenta) {
        this.descripcion = descripcion;
        this.porcenta = porcenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcenta() {
        return porcenta;
    }

    public void setPorcenta(double porcenta) {
        this.porcenta = porcenta;
    }

    public IList<DetalleNota> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(IList<DetalleNota> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }
    
    public void notasEstudiante(IList<Estudiante> listaEstudiante) {
        this.listaDetalle = new Lista<>();
        for (int i = 0; i < listaEstudiante.size(); i++) {
            listaDetalle.add(new DetalleNota(listaEstudiante.get(i)));
        }
    }
    
    @Override
    public String toString() {
       return this.getDescripcion() + " " + this.getPorcenta() ;
    }
    
}
