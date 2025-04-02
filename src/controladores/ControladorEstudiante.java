package controladores;

import Exepciones.MayorDeEdadExepcion;
import Exepciones.NoGuardarCodigoDuplicadoExepcion;
import Exepciones.NoSePuedeEliminarCodigoNoExisteExepcion;
import Exepciones.NoSePuedeModificarCodigoExepcion;
import Exepciones.UsuarioYaEstaExistenteExepcion;
import Util.IList;
import java.time.LocalDate;
import modelo.Estudiante;
import modelo.Persona;
import modelo.Programa;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorEstudiante {

    private IList<Persona> listaPersona;
    private IList<Programa> listaPrograma;

    public ControladorEstudiante() {
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
        this.listaPrograma = serializadora.Singleton.getSc().getPrograma();
    }

    public Persona buscarPersona(String codigo) {
        for (int i = 0; i < listaPersona.size(); i++) {
            if (codigo.equals(listaPersona.get(i).getCodigo())) {
                return listaPersona.get(i);
            }
        }
        return null;
    }

    public void guardarEstudiante(Estudiante estudiante) throws NoGuardarCodigoDuplicadoExepcion, UsuarioYaEstaExistenteExepcion {
        Persona aux = buscarPersona(estudiante.getCodigo());
        boolean aux1 = ValidarUsuario(estudiante.getUsuario());
        if (aux == null) {
            if (aux1) {
                listaPersona.add(estudiante);
                Singleton.getSc().escribirListaPersona();
            }else{
                throw new UsuarioYaEstaExistenteExepcion();
            }
        } else {
            throw new NoGuardarCodigoDuplicadoExepcion();
        }
    }

    public void modificarEstudiante(Estudiante estudiante) throws NoSePuedeModificarCodigoExepcion {
        Estudiante aux = (Estudiante) buscarPersona(estudiante.getCodigo());
        if (aux != null) {
            aux.setNombre(estudiante.getNombre());
            aux.setTelefono(estudiante.getTelefono());
            aux.setDireccion(estudiante.getDireccion());
            aux.setPrograma(estudiante.getPrograma());
            aux.setSemestre(estudiante.getSemestre());
            aux.setGenero(estudiante.getGenero());
            aux.setCorreo(estudiante.getCorreo());
            aux.setFechaNacimiento(estudiante.getFechaNacimiento());
            aux.setEdad(estudiante.calcularEdad());
            Singleton.getSc().escribirListaPersona();
        } else {
            throw new NoSePuedeModificarCodigoExepcion();
        }
    }

    public void eliminarEstudiante(String codigo) throws NoSePuedeEliminarCodigoNoExisteExepcion {
        Persona aux = buscarPersona(codigo);
        if (aux != null) {
            listaPersona.remove(aux);
            Singleton.getSc().escribirListaPersona();
        } else {
            throw new NoSePuedeEliminarCodigoNoExisteExepcion();
        }
    }

    public IList<Persona> getListaPersona() {
        return listaPersona;
    }

    public IList<Programa> getListaPrograma() {
        return listaPrograma;
    }

    public boolean ValidarUsuario(String usuario) {
        for (int i = 0; i < listaPersona.size(); i++) {
            if (usuario.equals(listaPersona.get(i).getUsuario())) {
                return false;
            }
        }
        return true;
    }

}
