package controladores;

import modelo.Laboratorio;
import modelo.Puesto;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorPuestos {

    private Laboratorio laboratorio;
    private Puesto[][] puestos;
    private Laboratorio[][]laboratorios;
    

    public ControladorPuestos(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
        this.puestos = laboratorio.getPuestos();
        this.laboratorios = serializadora.Singleton.getSc().getLaboratorios();
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public int getCantidadPuestos() {
        return laboratorio.getCantidad();
    }

    public Puesto getPuesto(int fila, int columna) {
        return puestos[fila][columna];
    }
    
    public void cambiarEstado (Puesto puesto){
        puesto.cambiarEstado();
        Singleton.getSc().escribirLaboratorio();
    }
    
    
    
}
