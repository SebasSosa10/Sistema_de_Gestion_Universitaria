package controladores;

import Exepciones.NoPuedeGuardarUnHorarioElMismoDIaExepcion;
import Exepciones.NoPuedePonerElHorarioSeCruzaExepcion;
import Exepciones.NoSeEliminoElHorarioExepcion;
import Exepciones.NoSeModificoElHorarioExepcion;
import Exepciones.NoSePuedeModificarPorElEstudianteExepcion;
import Exepciones.NoSeRegistroElHorarioExepcion;
import Exepciones.TieneQueExisterUnHorarioParaElEstudianteExepcion;
import Util.IList;
import java.time.LocalTime;
import modelo.Curso;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Horario;
import modelo.NumDia;

/**
 *
 * @author JOAN
 */
public class ControladorHorario {

    private IList<Curso> listaCurso;
    private final Curso curso;

    public ControladorHorario(Curso curso) {
        this.curso = curso;
        this.listaCurso = serializadora.Singleton.getSc().getCurso();
    }

    public IList<Curso> getListaCurso() {
        return listaCurso;
    }

    public IList<Horario> getListaHorario() {
        for (int i = 0; i < listaCurso.size(); i++) {
            return listaCurso.get(i).getListaHorario();
        }
        return null;
    }

    public void guardarHorario(Curso curso, Horario horario) throws NoSeRegistroElHorarioExepcion, NoPuedeGuardarUnHorarioElMismoDIaExepcion, NoPuedePonerElHorarioSeCruzaExepcion, NoSePuedeModificarPorElEstudianteExepcion {
        Curso aux = validarCurso(curso.getCodigoCurso());
        boolean aux1 = validarCursoDia(aux, horario);
        boolean aux2 = validarHoraDocente(curso, horario);
        if (aux != null) {
            if (aux1) {
                if (aux2) {
                    for (int i = 0; i < curso.getListaEstudiates().size(); i++) {
                        boolean aux3 = validarHoraEstudiante(curso.getListaEstudiates().get(i), horario);
                        if (aux3) {
                            throw new NoSePuedeModificarPorElEstudianteExepcion();
                        }
                    }
                    aux.guardarHorario(horario);
                    serializadora.Singleton.getSc().escribirListaCurso();
                } else {
                    throw new NoPuedePonerElHorarioSeCruzaExepcion();
                }
            } else {
                throw new NoPuedeGuardarUnHorarioElMismoDIaExepcion();
            }
        } else {
            throw new NoSeRegistroElHorarioExepcion();
        }
    }

    public Horario buscarHorario(NumDia dia) {
        for (int i = 0; i < curso.getListaHorario().size(); i++) {
            if (dia.equals(curso.getListaHorario().get(i).getDia())) {
                return curso.getListaHorario().get(i);
            }
        }
        return null;
    }

    public void eliminarHorario(Curso curso, NumDia dia) throws NoSeEliminoElHorarioExepcion, TieneQueExisterUnHorarioParaElEstudianteExepcion {
        Curso aux = validarCurso(curso.getCodigoCurso());
        if (aux != null) {
            if (!curso.getListaEstudiates().isEmpty() && aux.getListaHorario().size() == 1) {
                throw new TieneQueExisterUnHorarioParaElEstudianteExepcion();
            }
            curso.eliminarHorario(dia);
            serializadora.Singleton.getSc().escribirListaCurso();
        } else {
            throw new NoSeEliminoElHorarioExepcion();
        }
    }

    public Curso validarCurso(String curso) {
        for (int i = 0; i < listaCurso.size(); i++) {
            if (curso.equals(listaCurso.get(i).getCodigoCurso())) {
                return listaCurso.get(i);
            }
        }
        return null;
    }

    public boolean validarCursoDia(Curso curso, Horario horario) {
        for (int i = 0; i < curso.getListaHorario().size(); i++) {
            if (curso.getListaHorario().get(i).getDia().equals(horario.getDia())) {
                return false;
            }
        }
        return true;
    }

    public boolean validarHoraDocente(Curso curso, Horario horario) {
        for (int i = 0; i < listaCurso.size(); i++) {
            if (listaCurso.get(i).getDocente().equals(curso.getDocente())) {
                for (int j = 0; j < listaCurso.get(i).getListaHorario().size(); j++) {
                    Horario aux = listaCurso.get(i).getListaHorario().get(j);
                    if (listaCurso.get(i).getListaHorario().get(j).getDia().equals(horario.getDia())) {
                        if (aux.getHoraMinutoInicio().isBefore(horario.getHoraMinutoInicio())
                                && aux.getHoraMinutoFinal().isAfter(horario.getHoraMinutoInicio())
                                || aux.getHoraMinutoInicio().isBefore(horario.getHoraMinutoFinal())
                                && aux.getHoraMinutoFinal().isAfter(horario.getHoraMinutoFinal())
                                || aux.getHoraMinutoInicio().equals(horario.getHoraMinutoInicio())
                                || aux.getHoraMinutoFinal().equals(horario.getHoraMinutoFinal())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean validarHoraEstudiante(Estudiante estudiante, Horario horario) {
        for (int i = 0; i < listaCurso.size(); i++) {
            Estudiante aux1 = listaCurso.get(i).buscarEstudiante(estudiante.getCodigo());
            if (aux1 != null) {
                for (int j = 0; j < listaCurso.get(i).getListaHorario().size(); j++) {
                    if (listaCurso.get(i).getListaHorario().get(j).getDia().equals(horario.getDia())) {
                        Horario aux = listaCurso.get(i).getListaHorario().get(j);
                        if (aux.getHoraMinutoInicio().isBefore(horario.getHoraMinutoInicio())
                                && aux.getHoraMinutoFinal().isAfter(horario.getHoraMinutoInicio())
                                || aux.getHoraMinutoInicio().isBefore(horario.getHoraMinutoFinal())
                                && aux.getHoraMinutoFinal().isAfter(horario.getHoraMinutoFinal())
                                || aux.getHoraMinutoInicio().equals(horario.getHoraMinutoInicio())
                                || aux.getHoraMinutoFinal().equals(horario.getHoraMinutoFinal())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
