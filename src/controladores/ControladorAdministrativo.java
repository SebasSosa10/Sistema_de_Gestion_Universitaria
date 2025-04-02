package controladores;

import Exepciones.MayorDeEdadExepcion;
import Util.IList;
import modelo.Administrativo;
import modelo.Persona;
import serializadora.Singleton;
import Exepciones.NoGuardarCodigoDuplicadoExepcion;
import Exepciones.NoSePuedeModificarCodigoExepcion;
import Exepciones.NoSePuedeEliminarCodigoNoExisteExepcion;
import Exepciones.UsuarioYaEstaExistenteExepcion;
import java.time.LocalDate;

/**
 *
 * @author JOAN
 */
public class ControladorAdministrativo {

    private IList<Persona> listaPersona;

    public ControladorAdministrativo() {
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

    public void guardarAdministrativo(Administrativo administrativo) throws NoGuardarCodigoDuplicadoExepcion, MayorDeEdadExepcion, UsuarioYaEstaExistenteExepcion {
        Persona aux = buscarPersona(administrativo.getCodigo());
        boolean aux1 = esMayorDeEdad(administrativo.getFechaNacimiento());
        boolean aux2 = ValidarUsuario(administrativo.getUsuario());
        if (aux1) {
            if (aux2) {
                if (aux == null) {
                    listaPersona.add(administrativo);
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

    public void modificarAdministrativo(Administrativo administrativo) throws NoSePuedeModificarCodigoExepcion {
        Administrativo aux = (Administrativo) buscarPersona(administrativo.getCodigo());
        if (aux != null) {
            aux.setNombre(administrativo.getNombre());
            aux.setTelefono(administrativo.getTelefono());
            aux.setDireccion(administrativo.getDireccion());
            aux.setEspecializacion(administrativo.getEspecializacion());
            aux.setExperiencia(administrativo.getExperiencia());
            aux.setGenero(administrativo.getGenero());
            aux.setFechaNacimiento(administrativo.getFechaNacimiento());
            aux.setEdad(administrativo.calcularEdad());
            Singleton.getSc().escribirListaPersona();
        } else {
            throw new NoSePuedeModificarCodigoExepcion();
        }
    }

    public void eliminarAdministrativo(String codigo) throws NoSePuedeEliminarCodigoNoExisteExepcion {
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
