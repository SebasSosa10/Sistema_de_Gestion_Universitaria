package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author JOAN
 */
public class Mantenimiento implements Serializable {

    private Laboratorio laboratorio;
    private Estado estado;
    private String descripcion;
    private LocalDate fechaMantenimiento;

    public Mantenimiento(Laboratorio laboratorio, String descripcion, LocalDate fechaMantenimiento) {
        this.laboratorio = laboratorio;
        this.estado = estado.DISPONIBLE;
        this.descripcion = descripcion;
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(LocalDate fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }
    
}
