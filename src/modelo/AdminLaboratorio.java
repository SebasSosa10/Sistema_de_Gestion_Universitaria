package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author JOAN
 */
public class AdminLaboratorio extends Persona implements Serializable{

    private String especializacion;
    private int experiencia;

    public AdminLaboratorio(String especializacion, int experiencia, String codigo, String nombre, String telefono, String direccion, NumGenero genero, LocalDate fechaNacimiento, String usuario, String contrasenia, NumRol rol) {
        super(codigo, nombre, telefono, direccion, genero, fechaNacimiento, usuario, contrasenia, rol);
        this.especializacion = especializacion;
        this.experiencia = experiencia;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }   
    
}
