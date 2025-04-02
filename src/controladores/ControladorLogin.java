package controladores;

import Exepciones.ContrasenaIgualLaTemporalExepcion;
import Exepciones.ContraseñaNoValidaException;
import Exepciones.UsuarioContraseniaNoValidaException;
import Exepciones.UsuarioIgualAlTemporalExepcion;
import Exepciones.UsuarioNoExisteException;
import Exepciones.UsuarioYContraseñaIgualesExepcion;
import Util.IList;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.AdminGeneral;
import modelo.NumGenero;
import modelo.NumRol;
import modelo.Persona;
import modelo.Usuario;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorLogin {

    AdminGeneral admin = new AdminGeneral("desarrollo", 20, "123", "sosa", "123", "barrio", NumGenero.HOMBRE, LocalDate.MIN, "admin", "admin", NumRol.ADMINGENERAL);
    private IList<Persona> listaPersona;

    public ControladorLogin() {
        listaPersona = serializadora.Singleton.getSc().getPersona();
    }

    public Usuario login(String usuario, String contrasenia) throws UsuarioNoExisteException, ContraseñaNoValidaException, UsuarioContraseniaNoValidaException {
        if (usuario.equals("") || contrasenia.equals("")) {
            JOptionPane.showMessageDialog(null, "Por Favor Ingrese Datos Validos");
        }
        admin.setUsuarioNueva(false);
        admin.setContraseniaNueva(false);
        Persona aux = buscarUsuario(usuario);

        if (usuario.equalsIgnoreCase(admin.getUsuario()) && contrasenia.equalsIgnoreCase(admin.getContrasenia())) {
            return admin;
        }
        if (aux == null) {
            throw new UsuarioNoExisteException();
        }

        if (aux != null) {
            if (aux.getContrasenia().equals(contrasenia)) {
                return aux;
            } else {
                throw new ContraseñaNoValidaException();
            }
        }

        if (aux == null && !aux.getContrasenia().equals(contrasenia)) {
            throw new UsuarioContraseniaNoValidaException();
        }
        return null;
    }

    public Persona buscarUsuario(String Usuario) {
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getUsuario().equals(Usuario)) {
                return listaPersona.get(i);
            }
        }
        return null;
    }

    public void cambioContraseña(Persona persona, String usuarioNuevo, String contraseniaNueva) throws ContrasenaIgualLaTemporalExepcion, UsuarioIgualAlTemporalExepcion, UsuarioYContraseñaIgualesExepcion {
        if (!contraseniaNueva.equals(persona.getContrasenia())) {
            if (!usuarioNuevo.equals(persona.getUsuario())) {
                persona.setUsuario(usuarioNuevo);
                persona.setContrasenia(contraseniaNueva);
                persona.setUsuarioNueva(false);
                persona.setContraseniaNueva(false);
                Singleton.getSc().escribirListaPersona();
            } else {
                throw new UsuarioIgualAlTemporalExepcion();
            }
        } else {
            if (usuarioNuevo.equals(persona.getUsuario())) {
                throw new UsuarioYContraseñaIgualesExepcion();
            } else {
                throw new ContrasenaIgualLaTemporalExepcion();
            }
        }
    }

}
