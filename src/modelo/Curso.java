package modelo;

import Exepciones.EstudianteNoSeEliminoDelCursoExepcion;
import Exepciones.EstudianteYaExisteEnElCursoExepcion;
import Exepciones.NoGuardarCodigoDuplicadoExepcion;
import Exepciones.NoSeEliminoElHorarioExepcion;
import Exepciones.NoSeEncuentraElCursoParaEliminarExepcion;
import Exepciones.NoSeGuardoElCursoExepcion;
import Exepciones.NoSeModificoElCursoExepcion;
import Exepciones.NoSeRegistroElHorarioExepcion;
import Util.IList;
import Util.Lista;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import modelo.Horario;
import modelo.NumDia;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class Curso implements Serializable {

    public static final String ACTIVO = "Activo";
    public static final String FINALIZADO = "Finalizado";

    private String codigoCurso;
    private Programa programa;
    private Materia materia;
    private Docente docente;
    private String periodo;
    private String estado;
    private NumJornada jornada;
    IList<Horario> listaHorario;
    IList<Estudiante> listaEstudiates;
    IList<Nota> listaNotas;

    public Curso(String codigoCurso, Programa programa, Materia materia, Docente docente, String periodo, NumJornada jornada) {
        this.codigoCurso = codigoCurso;
        this.programa = programa;
        this.materia = materia;
        this.docente = docente;
        this.periodo = periodo;
        this.estado = ACTIVO;
        this.jornada = jornada;
        this.listaHorario = new Lista<>();
        this.listaEstudiates = new Lista<>();
        this.listaNotas = new Lista<>();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public NumJornada getJornada() {
        return jornada;
    }

    public void setJornada(NumJornada jornada) {
        this.jornada = jornada;
    }

    public IList<Horario> getListaHorario() {
        return listaHorario;
    }

    public void setListaHorario(IList<Horario> listaHorario) {
        this.listaHorario = listaHorario;
    }

    public IList<Estudiante> getListaEstudiates() {
        return listaEstudiates;
    }

    public void setListaEstudiates(IList<Estudiante> listaEstudiates) {
        this.listaEstudiates = listaEstudiates;
    }

    public IList<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(IList<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }

    @Override
    public String toString() {
        return this.programa.getNombre() + " " + this.getMateria().getNombreMateria() + " codigo: " + this.getCodigoCurso();
    }

    public void actualizarEstado() {
        LocalDate fechaActual = LocalDate.now();
        int mes = fechaActual.getMonthValue();
        LocalDate fechaInicio;
        LocalDate fechaFin;
        if (mes >= 1 && mes <= 6) {
            fechaInicio = LocalDate.of(fechaActual.getYear(), Month.JANUARY, 1);
            fechaFin = LocalDate.of(fechaActual.getYear(), Month.JUNE, 30);
        } else {
            fechaInicio = LocalDate.of(fechaActual.getYear(), Month.JULY, 1);
            fechaFin = LocalDate.of(fechaActual.getYear(), Month.DECEMBER, 31);
        }
        if (estado != null && estado.equals(ACTIVO)) {
            if (fechaActual.isAfter(fechaInicio) && fechaActual.isBefore(fechaFin.plusDays(1))) {
            } else {
                estado = FINALIZADO;
            }
        } else {
            if (fechaActual.isAfter(fechaInicio) && fechaActual.isBefore(fechaFin.plusDays(1))) {
                estado = ACTIVO;
            } else {
                estado = FINALIZADO;
            }
        }
    }

    //--------------------------------- CRUD HORARIO ----------------------------------------
    public Horario buscarHorario(NumDia dia) {
        for (int i = 0; i < listaHorario.size(); i++) {
            if (dia.equals(listaHorario.get(i).getDia())) {
                return listaHorario.get(i);
            }
        }
        return null;
    }

    public void guardarHorario(Horario horario) throws NoSeRegistroElHorarioExepcion {
        Horario aux = buscarHorario(horario.getDia());
        if (aux == null) {
            listaHorario.add(horario);
        } else {
            throw new NoSeRegistroElHorarioExepcion();
        }
    }

    public void eliminarHorario(NumDia dia) throws NoSeEliminoElHorarioExepcion {
        Horario aux = buscarHorario(dia);
        if (aux != null) {
            listaHorario.remove(aux);
        } else {
            throw new NoSeEliminoElHorarioExepcion();
        }
    }

    // ----------------------- CRUD ESTUDIANTE ----------------------------
    public Estudiante buscarEstudiante(String codigo) {
        for (int i = 0; i < listaEstudiates.size(); i++) {
            if (codigo.equals(listaEstudiates.get(i).getCodigo())) {
                return listaEstudiates.get(i);
            }
        }
        return null;
    }

    public void guardarEstudiante(Estudiante estudiante) throws EstudianteYaExisteEnElCursoExepcion {
        Estudiante aux = buscarEstudiante(estudiante.getCodigo());
        if (aux == null) {
            listaEstudiates.add(estudiante);
        } else {
            throw new EstudianteYaExisteEnElCursoExepcion();
        }
    }

    public void eliminarEstudiante(Estudiante estudiante) throws EstudianteNoSeEliminoDelCursoExepcion {
        Estudiante aux = buscarEstudiante(estudiante.getCodigo());
        if (aux != null) {
            listaEstudiates.remove(estudiante);
        } else {
            throw new EstudianteNoSeEliminoDelCursoExepcion();
        }
    }

}
