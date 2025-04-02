package modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author JOAN
 */
public class Persona extends Usuario implements Serializable {

    private String codigo;
    private String nombre;
    private String telefono;
    private String direccion;
    private NumGenero genero;
    private LocalDate fechaNacimiento;
    private int edad;
    private boolean usuarioNueva;
    private boolean contraseniaNueva;

    public Persona(String codigo, String nombre, String telefono, String direccion, NumGenero genero, LocalDate fechaNacimiento, String usuario, String contrasenia, NumRol rol) {
        super(usuario, contrasenia, rol);
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad();
        this.usuarioNueva = true;
        this.contraseniaNueva = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public NumGenero getGenero() {
        return genero;
    }

    public void setGenero(NumGenero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isContraseniaNueva() {
        return contraseniaNueva;
    }

    public void setContraseniaNueva(boolean contraseniaNueva) {
        this.contraseniaNueva = contraseniaNueva;
    }

    public boolean isUsuarioNueva() {
        return usuarioNueva;
    }

    public void setUsuarioNueva(boolean usuarioNueva) {
        this.usuarioNueva = usuarioNueva;
    }
    
    public int calcularEdad() {
    LocalDate fechaActual = LocalDate.now();
    int edad = fechaActual.getYear() - fechaNacimiento.getYear();
    if (fechaActual.getMonthValue() < fechaNacimiento.getMonthValue() ||
            (fechaActual.getMonthValue() == fechaNacimiento.getMonthValue() &&
            fechaActual.getDayOfMonth() < fechaNacimiento.getDayOfMonth())) {
        edad--;
    }
    return edad;
}

}
