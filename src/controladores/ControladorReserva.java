package controladores;

import Exepciones.NoExisteLaReservaExepcion;
import Exepciones.EstudianteNoExisteExepcion;
import Exepciones.LaboratoriaYaEstaEnMantenimientoExepcion;
import Exepciones.NoExisteElIdExepcion;
import Exepciones.ReservaPuestoExepcion;
import Exepciones.SoloUnaReservaExepcion;
import Util.IList;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import modelo.Docente;
import modelo.Estado;
import modelo.Estudiante;
import modelo.Laboratorio;
import modelo.Mantenimiento;
import modelo.NumRol;
import modelo.Persona;
import modelo.Puesto;
import modelo.Reserva;
import modelo.Usuario;

/**
 *
 * @author JOAN
 */
public class ControladorReserva {

    private IList<Persona> listaPersona;
    private IList<Mantenimiento> listaMantenimiento;
    private Puesto puesto;
    private Laboratorio[][] laboratorios;
    private Laboratorio laboratorio;

    public ControladorReserva(Laboratorio laboratorio, Usuario usuario, Puesto puesto) {
        this.laboratorio = laboratorio;
        this.puesto = puesto;
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
        this.laboratorios = serializadora.Singleton.getSc().getLaboratorios();
        this.listaMantenimiento = serializadora.Singleton.getSc().getMantenimiento();
    }

    public ControladorReserva(Usuario usuario) {
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
        this.listaMantenimiento = serializadora.Singleton.getSc().getMantenimiento();
        this.laboratorios = serializadora.Singleton.getSc().getLaboratorios();
    }

    public Estudiante buscarEstudiante(String id) throws EstudianteNoExisteExepcion, NoExisteElIdExepcion {
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getCodigo().equals(id)) {
                if (listaPersona.get(i) instanceof Estudiante) {
                    return (Estudiante) listaPersona.get(i);
                } else {
                    throw new EstudianteNoExisteExepcion();
                }
            }
        }
        throw new NoExisteElIdExepcion();
    }

    public Reserva buscarReserva(String codigo) throws NoExisteLaReservaExepcion {
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                Puesto[][] puestosLaboratorio = laboratorios[i][j].getPuestos();
                for (int k = 0; k < puestosLaboratorio.length; k++) {
                    for (int l = 0; l < puestosLaboratorio[k].length; l++) {
                        IList<Reserva> listaReserva = puestosLaboratorio[k][l].getListaReservas();
                        for (int m = 0; m < listaReserva.size(); m++) {
                            Reserva reserva = listaReserva.get(m);
                            if (reserva.getCodigoReserva().equals(codigo)) {
                                return reserva;
                            }
                        }
                    }
                }
            }
        }
        throw new NoExisteLaReservaExepcion();
    }

    public void guardarReserva(Reserva reserva) throws SoloUnaReservaExepcion, ReservaPuestoExepcion, LaboratoriaYaEstaEnMantenimientoExepcion {
        validarMantenimientoLaboratorio(reserva.getFecha());
        soloUnaReserva(reserva.getEstudiante());
        disponibilidadPuesto(reserva);
        puesto.getListaReservas().add(reserva);
        serializadora.Singleton.getSc().escribirLaboratorio();
    }

    public void disponibilidadPuesto(Reserva reserva) throws ReservaPuestoExepcion {
        for (int i = 0; i < puesto.getListaReservas().size(); i++) {
            if (puesto.getListaReservas().get(i).getFecha().equals(reserva.getFecha())) {
                if (cruzanHoras(puesto.getListaReservas().get(i), reserva)) {
                    throw new ReservaPuestoExepcion();
                }
            }
        }
    }

    public void soloUnaReserva(Estudiante estudiante) throws SoloUnaReservaExepcion {
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                Puesto[][] puestosLaboratorio = laboratorios[i][j].getPuestos();
                for (int k = 0; k < puestosLaboratorio.length; k++) {
                    for (int l = 0; l < puestosLaboratorio[k].length; l++) {
                        IList reservasPuesto = puestosLaboratorio[k][l].getListaReservas();
                        for (int m = 0; m < reservasPuesto.size(); m++) {
                            Reserva reserva = (Reserva) reservasPuesto.get(m);
                            if (reserva.getFecha().isAfter(LocalDate.now())) {
                                if (reserva.getEstudiante().getCodigo().equals(estudiante.getCodigo())) {
                                    throw new SoloUnaReservaExepcion();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean cruzanHoras(Reserva reservaExiste, Reserva nuevaReserva) {
        boolean inicio = (reservaExiste.getHoraInicio().isAfter(nuevaReserva.getHoraInicio()) && reservaExiste.getHoraInicio().isBefore(nuevaReserva.getHoraFin()))
                || (nuevaReserva.getHoraInicio().isAfter(reservaExiste.getHoraInicio()) && nuevaReserva.getHoraInicio().isBefore(reservaExiste.getHoraFin()));
        boolean fin = (reservaExiste.getHoraFin().isAfter(nuevaReserva.getHoraInicio()) && reservaExiste.getHoraFin().isBefore(nuevaReserva.getHoraFin()))
                || (nuevaReserva.getHoraFin().isAfter(reservaExiste.getHoraInicio()) && nuevaReserva.getHoraFin().isBefore(reservaExiste.getHoraFin()));
        boolean mitad = reservaExiste.getHoraInicio().isAfter(nuevaReserva.getHoraInicio()) && reservaExiste.getHoraFin().isBefore(nuevaReserva.getHoraFin())
                || nuevaReserva.getHoraInicio().isAfter(reservaExiste.getHoraInicio()) && nuevaReserva.getHoraFin().isBefore(reservaExiste.getHoraFin());
        return inicio || fin || mitad;
    }

    public void validarMantenimientoLaboratorio(LocalDate fecha) throws LaboratoriaYaEstaEnMantenimientoExepcion {
        for (int i = 0; i < listaMantenimiento.size(); i++) {
            Mantenimiento mantenimiento = listaMantenimiento.get(i);
            if (mantenimiento.getFechaMantenimiento().equals(fecha)) {
                if (mantenimiento.getLaboratorio().equals(laboratorio)) {
                    throw new LaboratoriaYaEstaEnMantenimientoExepcion();
                }
            }
        }
    }

    public void eliminarReserva(Reserva reserva) throws ReservaPuestoExepcion, LaboratoriaYaEstaEnMantenimientoExepcion, NoExisteLaReservaExepcion {
        validarMantenimientoLaboratorio(reserva.getFecha());
        boolean reservaEliminada = false;
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                Puesto[][] puestosLaboratorio = laboratorios[i][j].getPuestos();
                for (int k = 0; k < puestosLaboratorio.length; k++) {
                    for (int l = 0; l < puestosLaboratorio[k].length; l++) {
                        IList<Reserva> listaReserva = puestosLaboratorio[k][l].getListaReservas();
                        for (int m = 0; m < listaReserva.size(); m++) {
                            Reserva reservaExistente = listaReserva.get(m);
                            if (reservaExistente.equals(reserva)) {
                                listaReserva.remove(reservaExistente);
                                reservaEliminada = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (!reservaEliminada) {
            throw new NoExisteLaReservaExepcion();
        }
        serializadora.Singleton.getSc().escribirLaboratorio();
        String mensaje = "Se ha eliminado la reserva en el laboratorio: " + laboratorio.getNumLaboratorio();
        reserva.getEstudiante().getMensaje().add(mensaje);
        serializadora.Singleton.getSc().escribirListaPersona();
    }

    public void finalizarReservasPasadas() {
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                Puesto[][] puestosLaboratorio = laboratorios[i][j].getPuestos();
                for (int k = 0; k < puestosLaboratorio.length; k++) {
                    for (int l = 0; l < puestosLaboratorio[k].length; l++) {
                        IList<Reserva> listaReserva = puestosLaboratorio[k][l].getListaReservas();
                        for (int m = 0; m < listaReserva.size(); m++) {
                            Reserva reserva = listaReserva.get(m);
                            if (reserva.getFecha().equals(LocalDate.now()) && reserva.getHoraFin().isBefore(LocalTime.now())) {
                                listaReserva.remove(reserva);
                                puestosLaboratorio[k][l].setEstado(Estado.DISPONIBLE);
                                m--;
                            }
                        }
                    }
                }
            }
        }
        serializadora.Singleton.getSc().escribirLaboratorio();
    }

}
