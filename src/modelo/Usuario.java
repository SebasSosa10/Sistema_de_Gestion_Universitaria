package modelo;

import java.io.Serializable;

/**
 *
 * @author JOAN
 */

public class Usuario implements Serializable{
    
    private String usuario;
    private String contrasenia;
    private NumRol rol;

    public Usuario(String usuario, String contrasenia, NumRol rol) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public NumRol getRol() {
        return rol;
    }

    public void setRol(NumRol rol) {
        this.rol = rol;
    }

}
