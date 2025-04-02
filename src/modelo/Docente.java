package modelo;

import Util.IList;
import Util.Lista;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author JOAN
 */
public class Docente extends Persona implements Serializable {

    private String especialidad;
    private int experiencia;
    private String correo;

    public Docente(String especialidad, int experiencia, String correo, String codigo, String nombre, String telefono, String direccion, NumGenero genero, LocalDate fechaNacimiento, String usuario, String contrasenia, NumRol rol) {
        super(codigo, nombre, telefono, direccion, genero, fechaNacimiento, usuario, contrasenia, rol);
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.correo = correo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return this.getCodigo() + " " + this.getNombre();
    }

    public IList<Curso> getCursosActuales() {
        IList<Curso> cursos = serializadora.Singleton.getSc().getCurso();
        IList<Curso> cursosActuales = new Lista<>();
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            if (curso.getDocente().getCodigo().equals(getCodigo()) && curso.getEstado().equals(Curso.ACTIVO)) {
                cursosActuales.add(curso);
            }
        }
        return cursosActuales;
    }

    public IList<Curso> getHistorialCursos() {
        IList<Curso> historialCursos = serializadora.Singleton.getSc().getCurso();
        IList<Curso> cursosFinalizados = new Lista<>();
        for (int i = 0; i < historialCursos.size(); i++) {
            Curso curso = historialCursos.get(i);
            if (curso.getEstado().equals(Curso.FINALIZADO)) {
                cursosFinalizados.add(curso);
            }
        }
        return cursosFinalizados;
    }

}
