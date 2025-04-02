package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author JOAN
 */
public class Horario implements Serializable {

    private NumDia dia;
    private LocalTime horaMinutoInicio;
    private LocalTime horaMinutoFinal;
    private int duracion;

    public Horario(NumDia dia, LocalTime horaMinutoInicio, int duracion) {
        this.dia = dia;
        this.horaMinutoInicio = horaMinutoInicio;
        this.duracion = duracion;
        this.horaMinutoFinal = horaMinutoInicio.plusHours(duracion);
    }

    public NumDia getDia() {
        return dia;
    }

    public void setDia(NumDia dia) {
        this.dia = dia;
    }

    public LocalTime getHoraMinutoInicio() {
        return horaMinutoInicio;
    }

    public void setHoraMinutoInicio(LocalTime horaMinutoInicio) {
        this.horaMinutoInicio = horaMinutoInicio;
    }

    public LocalTime getHoraMinutoFinal() {
        return horaMinutoFinal;
    }

    public void setHoraMinutoFinal(LocalTime horaMinutoFinal) {
        this.horaMinutoFinal = horaMinutoFinal;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public String toString() {
        return this.getDia() + " horaInicio: " + this.getHoraMinutoInicio() + "HoraFinal" + this.getHoraMinutoFinal();
    }
}
