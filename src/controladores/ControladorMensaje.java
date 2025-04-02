package controladores;

import Exepciones.EstudianteNoExisteExepcion;
import Exepciones.NoExisteElIdExepcion;
import Util.IList;
import modelo.Estudiante;
import modelo.NumRol;
import modelo.Persona;
import modelo.Usuario;

/**
 *
 * @author JOAN
 */
public class ControladorMensaje {

    private IList<Persona> listaPersona;
    private Usuario usuario;
    private Estudiante estudiante;

    public ControladorMensaje(Usuario usuario) {
        this.estudiante = (Estudiante) usuario;
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
    }

    public Estudiante buscarEstudiante(Usuario usuario) {
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getRol().equals(NumRol.ESTUDIANTE)) {
                Estudiante aux = (Estudiante) listaPersona.get(i);
                if (aux.getUsuario().equals(usuario.getUsuario())) {
                    return aux;
                }
            }
        }
        return null;
    }

    public IList<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(IList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

}
