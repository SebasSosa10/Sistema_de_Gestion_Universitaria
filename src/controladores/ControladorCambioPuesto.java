package controladores;

import Exepciones.LosPuestosTieneQueSerMayoresExepcion;
import Exepciones.LosPuestosTieneQueSerMenoresExepcion;
import Exepciones.SoloUnaReservaExepcion;
import Util.IList;
import modelo.Laboratorio;
import modelo.Puesto;
import modelo.Reserva;

/**
 *
 * @author JOAN
 */
public class ControladorCambioPuesto {

    private Laboratorio laboratorio;
    private Laboratorio[][] laboratorios;

    public ControladorCambioPuesto(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
        this.laboratorios = serializadora.Singleton.getSc().getLaboratorios();
    }

    public void modificarPuestos(int puestos) throws LosPuestosTieneQueSerMayoresExepcion, LosPuestosTieneQueSerMenoresExepcion {
        if (puestos >= 1) {
            if (puestos <= 20) {
                String mensaje = "Hubo una modificacion en el laboratorio de puestos: " + laboratorio.getNumLaboratorio();
                guardarMensaje(mensaje);
                laboratorio.generarPuestos(puestos);
            } else {
                throw new LosPuestosTieneQueSerMenoresExepcion();
            }
        } else {
            throw new LosPuestosTieneQueSerMayoresExepcion();
        }
    }

    public void guardarMensaje(String mensaje) {
        for (int i = 0; i < laboratorios.length; i++) {
            for (int j = 0; j < laboratorios[i].length; j++) {
                Puesto[][] puestosLaboratorio = laboratorios[i][j].getPuestos();
                for (int k = 0; k < puestosLaboratorio.length; k++) {
                    for (int l = 0; l < puestosLaboratorio[k].length; l++) {
                        IList<Reserva> listaReserva = puestosLaboratorio[k][l].getListaReservas();
                        for (int m = 0; m < listaReserva.size(); m++) {
                            listaReserva.get(m).getEstudiante().getMensaje().add(mensaje);
                            serializadora.Singleton.getSc().escribirListaPersona();
                            serializadora.Singleton.getSc().escribirLaboratorio();
                        }
                    }
                }
            }
        }
    }

    public int getPuestos() {
        return laboratorio.getCantidad();
    }
}
