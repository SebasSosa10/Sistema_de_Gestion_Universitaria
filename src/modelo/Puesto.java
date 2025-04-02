package modelo;

import Util.IList;
import Util.Lista;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author JOAN
 */
public class Puesto implements Serializable {

    private Estado estado;
    private String identificador;
    private IList<Reserva> listaReservas;
    private IList<Prestamo> prestamos;

    public Puesto(String identificador) {
        this.estado = estado.DISPONIBLE;
        this.identificador = identificador;
        this.listaReservas = new Lista<>();
        this.prestamos = new Lista<>();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public IList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(IList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public IList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(IList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public String codigoReserva() {
        return "codigo " + (listaReservas.size() + 1);
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
        final Puesto other = (Puesto) obj;
        return Objects.equals(this.identificador, other.identificador);
    }

    public void cambiarEstado() {
        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reserva = listaReservas.get(i);
            if (reserva.getFecha().equals(hoy)) {
                if (ahora.isBefore(reserva.getHoraInicio())) {
                    this.estado = estado.DISPONIBLE;
                } else if (validarOcupado(reserva)) {
                    this.estado = estado.OCUPADO;
                    return;
                } else if (ahora.isAfter(reserva.getHoraFin())) {
                    this.estado = estado.DISPONIBLE;
                }
            }
        }
    }

    private boolean validarOcupado(Reserva reserva) {
        return reserva.getHoraInicio().isBefore(LocalTime.now()) && reserva.getHoraFin().isAfter(LocalTime.now());
    }

}
