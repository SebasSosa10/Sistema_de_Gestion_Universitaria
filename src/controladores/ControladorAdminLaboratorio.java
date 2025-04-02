package controladores;

import Exepciones.MayorDeEdadExepcion;
import Exepciones.NoGuardarCodigoDuplicadoExepcion;
import Exepciones.NoSePuedeEliminarCodigoNoExisteExepcion;
import Exepciones.NoSePuedeModificarCodigoExepcion;
import Exepciones.UsuarioYaEstaExistenteExepcion;
import Util.IList;
import java.time.LocalDate;
import modelo.AdminLaboratorio;
import modelo.Persona;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorAdminLaboratorio {

    private IList<Persona> listaPersona;

    public ControladorAdminLaboratorio() {
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

    public void guardarAdminLaboratorio(AdminLaboratorio adminLaboratorio) throws NoGuardarCodigoDuplicadoExepcion, MayorDeEdadExepcion, UsuarioYaEstaExistenteExepcion {
        Persona aux = buscarPersona(adminLaboratorio.getCodigo());
        boolean aux1 = esMayorDeEdad(adminLaboratorio.getFechaNacimiento());
        boolean aux2 = ValidarUsuario(adminLaboratorio.getUsuario());
        if (aux1) {
            if (aux2) {
                if (aux == null) {
                    listaPersona.add(adminLaboratorio);
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

    public void modificarAdminLaboratorio(AdminLaboratorio adminLaboratorio) throws NoSePuedeModificarCodigoExepcion {
        AdminLaboratorio aux = (AdminLaboratorio) buscarPersona(adminLaboratorio.getCodigo());
        if (aux != null) {
            aux.setNombre(adminLaboratorio.getNombre());
            aux.setTelefono(adminLaboratorio.getTelefono());
            aux.setDireccion(adminLaboratorio.getDireccion());
            aux.setEspecializacion(adminLaboratorio.getEspecializacion());
            aux.setExperiencia(adminLaboratorio.getExperiencia());
            aux.setGenero(adminLaboratorio.getGenero());
            aux.setFechaNacimiento(adminLaboratorio.getFechaNacimiento());
            aux.setEdad(adminLaboratorio.calcularEdad());
            Singleton.getSc().escribirListaPersona();
        } else {
            throw new NoSePuedeModificarCodigoExepcion();
        }
    }

    public void eliminarAdminLaboratorio(String codigo) throws NoSePuedeEliminarCodigoNoExisteExepcion {
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
            if (!usuario.equals(listaPersona.get(i).getUsuario())) {
                return true;
            }
        }
        return false;
    }
}
