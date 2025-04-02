package modelo;

import Util.IList;
import Util.IQueue;
import Util.Lista;
import Util.ListaQueue;
import java.io.Serializable;
import modelo.Curso;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class Laboratorio implements Serializable {

    private int numLaboratorio;
    private Estado estado;
    private Puesto[][] puestos;
    private int cantidad;
    private IList<Reserva> listaReserva;
    private IList<Prestamo> listaPrestamo;
    private IQueue<Prestamo> colaPrestamo;

    public Laboratorio(int numLaboratorio) {
        this.numLaboratorio = numLaboratorio;
        this.estado = Estado.DISPONIBLE;
        this.puestos = new Puesto[2][4];
        this.cantidad = 8;
        this.colaPrestamo = new ListaQueue<>();
        inicializarPuestos();
    }

    public int getNumLaboratorio() {
        return numLaboratorio;
    }

    public void setNumLaboratorio(int numLaboratorio) {
        this.numLaboratorio = numLaboratorio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Puesto[][] getPuestos() {
        return puestos;
    }

    public void setPuestos(Puesto[][] puestos) {
        this.puestos = puestos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public IList<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(IList<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public IList<Prestamo> getListaPrestamo() {
        return listaPrestamo;
    }

    public void setListaPrestamo(IList<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }

    public void generarPuestos(int numPuestos) {
        int filas = numPuestos / 4;
        Puesto[][] numPuestosNuevos;
        if (numPuestos % 4 != 0) {
            numPuestosNuevos = new Puesto[filas + 1][];
            for (int i = 0; i < filas; i++) {
                numPuestosNuevos[i] = new Puesto[4];
            }
            int numPuestosFaltan = numPuestos % 4;
            numPuestosNuevos[numPuestosNuevos.length - 1] = new Puesto[numPuestosFaltan];
        } else {
            numPuestosNuevos = new Puesto[filas][4];
        }
        this.cantidad = numPuestos;
        this.puestos = numPuestosNuevos;
        inicializarPuestos();
        Singleton.getSc().escribirLaboratorio();
    }

    public void inicializarPuestos() {
        int identificador = 1;
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {
                puestos[i][j] = new Puesto("" + identificador);
                identificador += 1;
            }
        }
    }

    public int cambiarCapacidad() {
        int filas = cantidad / 4;
        if (cantidad % 4 != 0) {
            return filas + 1;
        }
        return filas;
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
        final Laboratorio other = (Laboratorio) obj;
        return this.numLaboratorio == other.numLaboratorio;
    }

}
