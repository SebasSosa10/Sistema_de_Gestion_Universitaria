package controladores;

import Exepciones.ElPrestamoEstaEnCola;
import Exepciones.EstudianteNoExisteExepcion;
import Exepciones.LaboratoriaYaEstaEnMantenimientoExepcion;
import Exepciones.NoExisteElIdExepcion;
import Exepciones.OcupadoElPuestoExepcion;
import Exepciones.ReservaExistenteExcepcion;
import Exepciones.SoloUnaReservaExepcion;
import Exepciones.YatieneUnPrestamoExepcion;
import Util.IList;
import Util.IQueue;
import Util.Nodo;
import java.time.LocalDate;
import java.time.LocalTime;
import modelo.Estado;
import modelo.Estudiante;
import modelo.Laboratorio;
import modelo.Mantenimiento;
import modelo.Persona;
import modelo.Prestamo;
import modelo.Puesto;
import modelo.Reserva;

/**
 *
 * @author JOAN
 */
public class ControladorPrestamo {

    private IList<Persona> listaPersona;
    private Laboratorio[][] laboratorios;
    private IList<Mantenimiento> listaMantenimiento;
    private Laboratorio laboratorio;
    private Puesto puesto;
    IQueue<Prestamo> colaPrestamo;

    public ControladorPrestamo(Laboratorio laboratorio, Puesto puesto) {
        this.laboratorio = laboratorio;
        this.puesto = puesto;
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
        this.colaPrestamo = serializadora.Singleton.getSc().getColaPrestamo();
        this.laboratorios = serializadora.Singleton.getSc().getLaboratorios();
        this.listaMantenimiento = serializadora.Singleton.getSc().getMantenimiento();

    }

    public ControladorPrestamo(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
        this.laboratorios = serializadora.Singleton.getSc().getLaboratorios();
        this.listaMantenimiento = serializadora.Singleton.getSc().getMantenimiento();
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

    public void guardarPrestamo(Prestamo prestamo) throws LaboratoriaYaEstaEnMantenimientoExepcion, OcupadoElPuestoExepcion, YatieneUnPrestamoExepcion, ReservaExistenteExcepcion, ElPrestamoEstaEnCola {
        validarMantenimientoLaboratorio(prestamo.getFecha());
        if (estudianteTienePrestamoActivo(prestamo.getEstudiante())) {
            throw new YatieneUnPrestamoExepcion();
        }
        IList<Reserva> reservasPuesto = puesto.getListaReservas();
        for (int i = 0; i < reservasPuesto.size(); i++) {
            Reserva reserva = reservasPuesto.get(i);
            if (reserva.getFecha().equals(prestamo.getFecha())) {
                throw new ReservaExistenteExcepcion();
            }
        }
        if (puesto.getPrestamos().size() < 1) {
            soloUnPrestamo(prestamo.getEstudiante());
            puesto.getPrestamos().add(prestamo);
            puesto.setEstado(Estado.OCUPADO);
            serializadora.Singleton.getSc().escribirLaboratorio();
        } else {
            colaPrestamo.enQueue(prestamo);
            serializadora.Singleton.getSc().escribirColaPrestamo();
            throw new ElPrestamoEstaEnCola();
        }
    }

    public void finalizarPrestamosPasados() {
        LocalTime horaActual = LocalTime.now();
        if (this.puesto != null) {
            for (int i = 0; i < laboratorios.length; i++) {
                for (int j = 0; j < laboratorios[i].length; j++) {
                    Puesto[][] puestosLaboratorio = laboratorios[i][j].getPuestos();
                    for (int k = 0; k < puestosLaboratorio.length; k++) {
                        for (int l = 0; l < puestosLaboratorio[k].length; l++) {
                            IList<Prestamo> listaPrestamos = puestosLaboratorio[k][l].getPrestamos();
                            for (int m = 0; m < listaPrestamos.size(); m++) {
                                Prestamo prestamo = listaPrestamos.get(m);
                                if (horaActual.isAfter(prestamo.getHoraFin())) {
                                    listaPrestamos.remove(prestamo);
                                    if (this.puesto != null) {
                                        this.puesto.setEstado(Estado.DISPONIBLE);
                                    } else {
                                    }
                                    m--;
                                }
                            }
                        }
                    }
                }
            }
        }
        while (colaPrestamo != null && !colaPrestamo.isEmpty()) {
            Prestamo prestamoEnCola = colaPrestamo.peek();
            if (horaActual.isAfter(prestamoEnCola.getHoraFin())) {
                colaPrestamo.deQueue();
                serializadora.Singleton.getSc().escribirColaPrestamo();
            } else {
                break;
            }
        }
        if (this.puesto != null && this.puesto.getEstado() == Estado.DISPONIBLE && colaPrestamo != null && !colaPrestamo.isEmpty()) {
            Prestamo siguientePrestamo = colaPrestamo.deQueue();
            this.puesto.getPrestamos().add(siguientePrestamo);
            this.puesto.setEstado(Estado.OCUPADO);
            serializadora.Singleton.getSc().escribirLaboratorio();
        }
    }

    public void soloUnPrestamo(Estudiante estudiante) throws YatieneUnPrestamoExepcion {
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                Puesto[][] puestosLaboratorio = laboratorios[i][j].getPuestos();
                for (int k = 0; k < puestosLaboratorio.length; k++) {
                    for (int l = 0; l < puestosLaboratorio[k].length; l++) {
                        IList PrestamoPuesto = puestosLaboratorio[k][l].getPrestamos();
                        for (int m = 0; m < PrestamoPuesto.size(); m++) {
                            Prestamo prestamo = (Prestamo) PrestamoPuesto.get(m);
                            if (prestamo.getFecha().isAfter(LocalDate.now())) {
                                if (prestamo.getEstudiante().getCodigo().equals(estudiante.getCodigo())) {
                                    throw new YatieneUnPrestamoExepcion();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean estudianteTienePrestamoActivo(Estudiante estudiante) {
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                Puesto[][] puestosLaboratorio = laboratorios[i][j].getPuestos();
                for (int k = 0; k < puestosLaboratorio.length; k++) {
                    for (int l = 0; l < puestosLaboratorio[k].length; l++) {
                        IList<Prestamo> prestamosPuesto = puestosLaboratorio[k][l].getPrestamos();
                        for (int m = 0; m < prestamosPuesto.size(); m++) {
                            Prestamo prestamo = prestamosPuesto.get(m);
                            if (prestamo.getEstudiante().getCodigo().equals(estudiante.getCodigo()) && prestamo.getFecha().isEqual(LocalDate.now())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public IQueue<Prestamo> getColaPrestamo() {
        return colaPrestamo;
    }

    public void setColaPrestamo(IQueue<Prestamo> colaPrestamo) {
        this.colaPrestamo = colaPrestamo;
    }

}
