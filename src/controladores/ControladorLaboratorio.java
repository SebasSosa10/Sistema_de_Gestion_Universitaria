package controladores;

import Util.IList;
import java.time.LocalDate;
import modelo.Estado;
import modelo.Laboratorio;
import modelo.Mantenimiento;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorLaboratorio {

    private Laboratorio[][] laboratorio;
    IList<Mantenimiento> listaMantenimiento;

    public ControladorLaboratorio() {
        this.laboratorio = Singleton.getSc().getLaboratorios();
        this.listaMantenimiento = Singleton.getSc().getMantenimiento();
        if (laboratorio[0][0] == null) {
            inicializar();
        }
        cambiarEstado();
    }

    public String descripcionMantenimiento(Laboratorio laboratorio) {
        for (int i = 0; i < listaMantenimiento.size(); i++) {
            Mantenimiento mantenimiento = listaMantenimiento.get(i);
            if (mantenimiento.getFechaMantenimiento().equals(LocalDate.now())) {
                if (laboratorio.equals(mantenimiento.getLaboratorio())) {
                    return mantenimiento.getDescripcion();
                }
            }
        }
        return null;
    }

    public void inicializar() {
        int numeroLaboratorio = 0;
        for (int i = 0; i < laboratorio.length; i++) {
            for (int j = 0; j < laboratorio[i].length; j++) {
                if (i == 0) {
                    numeroLaboratorio = 400 + (5 - j);
                } else if (i == 1) {
                    numeroLaboratorio = 406;
                } else {
                    numeroLaboratorio = 400 + (j + 7);
                }
                laboratorio[i][j] = new Laboratorio(numeroLaboratorio);
            }
        }
        Singleton.getSc().escribirLaboratorio();
    }

    public Laboratorio obtenerLaboratorio(int fila, int columna) {
        return laboratorio[fila][columna];
    }

    public void cambiarEstado() {
        for (int i = 0; i < laboratorio.length; i++) {
            for (int j = 0; j < laboratorio[i].length; j++) {
                laboratorio[i][j].setEstado(Estado.DISPONIBLE);
            }
        }
        for (int i = 0; i < listaMantenimiento.size(); i++) {
            if (listaMantenimiento.get(i).getFechaMantenimiento().equals(LocalDate.now())) {
                for (int j = 0; j < laboratorio.length; j++) {
                    for (int k = 0; k < laboratorio[j].length; k++) {
                        System.out.println(laboratorio[j][k]);
                        if (laboratorio[j][k].equals(listaMantenimiento.get(i).getLaboratorio())) {
                            laboratorio[j][k].setEstado(Estado.MANTENIMIENTO);
                        }
                    }
                }
            }
        }
        Singleton.getSc().escribirLaboratorio();
    }
}
