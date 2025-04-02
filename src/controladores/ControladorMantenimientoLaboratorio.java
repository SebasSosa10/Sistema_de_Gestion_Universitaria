package controladores;

import Exepciones.ExisteUnMantenimiientoEsediaExepcion;
import Util.IList;
import java.time.LocalDate;
import modelo.Estado;
import modelo.Laboratorio;
import modelo.Mantenimiento;
import modelo.Puesto;
import modelo.Reserva;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorMantenimientoLaboratorio {

    Laboratorio laboratorio;
    private IList<Mantenimiento> listaMantenimientos;
    Laboratorio[][] laboratorios;

    public ControladorMantenimientoLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
        this.laboratorios = serializadora.Singleton.getSc().getLaboratorios();
        this.listaMantenimientos = serializadora.Singleton.getSc().getMantenimiento();
    }

    public void guardarMantenimiento(Mantenimiento mantenimiento) throws ExisteUnMantenimiientoEsediaExepcion {
        existeUnMantenimiento(mantenimiento);
        String mensaje = "El laboratorio: " + laboratorio.getNumLaboratorio() +" entró en mantenimiento";
        guardarMensaje(mensaje);
        listaMantenimientos.add(mantenimiento);
        Singleton.getSc().escribirListaMantenimiento();
    }

    public void existeUnMantenimiento(Mantenimiento mantenimiento) throws ExisteUnMantenimiientoEsediaExepcion {
        for (int i = 0; i < listaMantenimientos.size(); i++) {
            if (listaMantenimientos.get(i).getFechaMantenimiento().equals(mantenimiento.getFechaMantenimiento())) {
                throw new ExisteUnMantenimiientoEsediaExepcion();
            }
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
    

}
