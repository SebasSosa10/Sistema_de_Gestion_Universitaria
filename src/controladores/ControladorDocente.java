package controladores;

import Exepciones.MayorDeEdadExepcion;
import Exepciones.NoGuardarCodigoDuplicadoExepcion;
import Exepciones.NoSePuedeEliminarCodigoNoExisteExepcion;
import Exepciones.NoSePuedeModificarCodigoExepcion;
import Exepciones.UsuarioYaEstaExistenteExepcion;
import Util.IList;
import java.time.LocalDate;
import modelo.AdminLaboratorio;
import modelo.Docente;
import modelo.Persona;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorDocente {

    private IList<Persona> listaPersona;

    public ControladorDocente() {
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
    }

    public Persona buscarPersona(String codigo) {
        for (int i = 0; i < listaPersona.size(); i++) {
            if (codigo.equals(listaPersona.get(i).getCodigo())) {
                return listaPersona.get(i);
            }
        }
        return null;
    }

    public void guardarDocente(Docente docente) throws NoGuardarCodigoDuplicadoExepcion, MayorDeEdadExepcion, UsuarioYaEstaExistenteExepcion {
        Persona aux = buscarPersona(docente.getCodigo());
        boolean aux1 = esMayorDeEdad(docente.getFechaNacimiento());
        boolean aux2 = ValidarUsuario(docente.getUsuario());
        if (aux1) {
            if (aux2) {
                if (aux == null) {
                    listaPersona.add(docente);
                    Singleton.getSc().escribirListaPersona();
                } else {
                    throw new NoGuardarCodigoDuplicadoExepcion();
                }
            } else {
                throw new UsuarioYaEstaExistenteExepcion();
            }
        } else {
            throw new MayorDeEdadExepcion();
        }
    }

    public void modificarDocente(Docente docente) throws NoSePuedeModificarCodigoExepcion {
        Docente aux = (Docente) buscarPersona(docente.getCodigo());
        if (aux != null) {
            aux.setNombre(docente.getNombre());
            aux.setTelefono(docente.getTelefono());
            aux.setDireccion(docente.getDireccion());
            aux.setEspecialidad(docente.getEspecialidad());
            aux.setExperiencia(docente.getExperiencia());
            aux.setGenero(docente.getGenero());
            aux.setCorreo(docente.getCorreo());
            aux.setFechaNacimiento(docente.getFechaNacimiento());
            aux.setEdad(docente.calcularEdad());
            Singleton.getSc().escribirListaPersona();
        } else {
            throw new NoSePuedeModificarCodigoExepcion();
        }
    }

    public void eliminarDocente(String codigo) throws NoSePuedeEliminarCodigoNoExisteExepcion {
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

    public boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        return fechaNacimiento.plusYears(18).isBefore(fechaActual) || fechaNacimiento.plusYears(18).isEqual(fechaActual);
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
