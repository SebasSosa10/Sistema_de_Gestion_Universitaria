package modelo;

import Util.IList;
import java.io.Serializable;

/**
 *
 * @author JOAN
 */
public class DetalleNota implements Serializable{

    private Estudiante estudiante;
    private double valor;
    private boolean calificado;

    public DetalleNota(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.valor = 0;
        this.calificado = false;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isCalifacdo() {
        return calificado;
    }

    public void setCalifacdo(boolean califacdo) {
        this.calificado = califacdo;
    }
}
