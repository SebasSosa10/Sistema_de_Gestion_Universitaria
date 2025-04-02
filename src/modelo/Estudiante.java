package modelo;

import Util.IList;
import Util.Lista;
import java.awt.List;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author JOAN
 */
public class Estudiante extends Persona implements Serializable {

    private Programa programa;
    private NumSemestre semestre;
    private String correo;
    private IList<Nota> listaNota;
    private IList<String> mensaje = new Lista();

    public Estudiante(Programa programa, NumSemestre semestre, String correo, String codigo, String nombre, String telefono, String direccion, NumGenero genero, LocalDate fechaNacimiento, String usuario, String contrasenia, NumRol rol) {
        super(codigo, nombre, telefono, direccion, genero, fechaNacimiento, usuario, contrasenia, rol);
        this.programa = programa;
        this.semestre = semestre;
        this.correo = correo;
        this.listaNota = new Lista<>();
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public NumSemestre getSemestre() {
        return semestre;
    }

    public void setSemestre(NumSemestre semestre) {
        this.semestre = semestre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public IList<Nota> getListaNota() {
        return listaNota;
    }

    public void setListaNota(IList<Nota> listaNota) {
        this.listaNota = listaNota;
    }

    public IList<String> getMensaje() {
        return mensaje;
    }

    public void setMensaje(IList<String> mensaje) {
        this.mensaje = mensaje;
    }

    public void guardarMensaje(String mensaje) {
        this.mensaje.add(mensaje);
    }

    @Override
    public String toString() {
        return this.getNombre() + "  de " + this.programa.getNombre();
    }

    public IList<Curso> getCursosMatriculados() {
        IList<Curso> cursos = serializadora.Singleton.getSc().getCurso();
        IList<Curso> cursosMatriculados = new Lista<>();
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            if (curso.getEstado().equals(Curso.ACTIVO)) {
                Lista<Estudiante> estudiantesMatriculados = (Lista<Estudiante>) curso.getListaEstudiates();
                for (int j = 0; j < estudiantesMatriculados.size(); j++) {
                    if (estudiantesMatriculados.get(j).getCodigo().equals(getCodigo())) {
                        cursosMatriculados.add(curso);
                    }
                }
            }
        }
        return cursosMatriculados;
    }

    public IList<Curso> getHistorialCursos() {
        IList<Curso> historialCursos = (Lista<Curso>) serializadora.Singleton.getSc().getCurso();
        IList<Curso> cursosFinalizados = new Lista<Curso>();
        for (int i = 0; i < historialCursos.size(); i++) {
            Curso curso = historialCursos.get(i);
            if (curso.getEstado().equals(Curso.FINALIZADO)) {
                cursosFinalizados.add(curso);
            }
        }
        return cursosFinalizados;
    }

}
