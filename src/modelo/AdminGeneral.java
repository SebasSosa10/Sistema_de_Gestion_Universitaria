package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author JOAN
 */
public class AdminGeneral extends Persona implements Serializable{

    private String especializacion;
    private int experiencia;

    public AdminGeneral(String especializacion, int experiencia, String codigo, String nombre, String telefono, String direccion, NumGenero genero, LocalDate fechaNacimiento, String usuario, String contrasenia, NumRol rol) {
        super(codigo, nombre, telefono, direccion, genero, fechaNacimiento, usuario, contrasenia, rol);
        this.especializacion = especializacion;
        this.experiencia = experiencia;
    }

}
