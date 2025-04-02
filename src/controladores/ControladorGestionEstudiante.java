package controladores;

import Exepciones.ElEstudianteNoHaSidoRegistrdoaUnCursoExepcion;
import Util.IList;
import Util.Lista;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Laboratorio;
import modelo.NumRol;
import modelo.Persona;
import modelo.Reserva;
import modelo.Usuario;

/**
 *
 * @author JOAN
 */
public class ControladorGestionEstudiante {

    private Usuario usuario;
    private Estudiante estudiante;
    private IList<Persona> listaPersona;
    private IList<Curso> listaCurso;
    Laboratorio[][] laboratorios;

    public ControladorGestionEstudiante(Usuario usuario) {
        this.estudiante = (Estudiante) usuario;
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
        this.listaCurso = serializadora.Singleton.getSc().getCurso();
        this.laboratorios = serializadora.Singleton.getSc().getLaboratorios();
    }

    public Estudiante buscarEstudiante(Usuario usuario) {
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getRol().equals(NumRol.ESTUDIANTE)) {
                Estudiante aux = (Estudiante) listaPersona.get(i);
                if (aux.getUsuario().equals(usuario.getUsuario())) {
                    return aux;
                }
            }
        }
        return null;
    }

    public IList<Curso> buscarCursoEstudiante(Usuario usuario) throws ElEstudianteNoHaSidoRegistrdoaUnCursoExepcion {
        IList<Curso> listaAux = new Lista<>();
        Estudiante aux = buscarEstudiante(usuario);
        if (aux != null) {
            String periodoActual = calcularPeriodo();
            for (int i = 0; i < listaCurso.size(); i++) {
                for (int j = 0; j < listaCurso.get(i).getListaEstudiates().size(); j++) {
                    if (listaCurso.get(i).getListaEstudiates().get(j).getCodigo().equals(aux.getCodigo())) {
                        if (listaCurso.get(i).getListaEstudiates().get(j) != null) {
                            if (listaCurso.get(i).getPeriodo().equals(periodoActual)) {
                                listaAux.add(listaCurso.get(i));
                            }
                        } else {
                            throw new ElEstudianteNoHaSidoRegistrdoaUnCursoExepcion();
                        }
                    }
                }
            }
        }
        return listaAux;
    }

    public String calcularPeriodo() {
        LocalDate fechaActual = LocalDate.now();
        int anio = LocalDate.now().getYear();
        LocalDate periodo1Inicio = LocalDate.of(anio, 1, 1);
        LocalDate periodo1Fin = LocalDate.of(anio, 6, 30);
        LocalDate periodo2Inicio = LocalDate.of(anio, 7, 1);
        LocalDate periodo2Fin = LocalDate.of(anio, 12, 31);
        if (fechaActual.isAfter(periodo1Inicio) && fechaActual.isBefore(periodo1Fin.plusDays(1))) {
            return "PERIODO_" + anio + "_1";
        } else if (fechaActual.isAfter(periodo2Inicio) && fechaActual.isBefore(periodo2Fin.plusDays(1))) {
            return "PERIODO_" + anio + "_2";
        } else {
            return " ";
        }
    }

    public IList<Reserva> buscarReservaActiva() {
        IList<Reserva> listaReservaEstudiante = new Lista<>();
        if (laboratorios[0][0] != null) {
            for (int i = 0; i < laboratorios.length; i++) {
                for (int j = 0; j < laboratorios[i].length; j++) {
                    for (int k = 0; k < laboratorios[i][j].getPuestos().length; k++) {
                        for (int l = 0; l < laboratorios[i][j].getPuestos()[k].length; l++) {
                            for (int m = 0; m < laboratorios[i][j].getPuestos()[k][l].getListaReservas().size(); m++) {
                                if (laboratorios[i][j].getPuestos()[k][l].getListaReservas().get(m).getEstudiante().getCodigo().equals(estudiante.getCodigo())) {
                                    listaReservaEstudiante.add(laboratorios[i][j].getPuestos()[k][l].getListaReservas().get(m));
                                }
                            }
                        }
                    }
                }
            }
            return listaReservaEstudiante;
        } else {
            JOptionPane.showConfirmDialog(null, "No hay reservas");
        }
        return null;
    }

    public IList<Curso> getCursosActuales() {
        return estudiante.getCursosMatriculados();
    }

    public IList<Curso> getHistorialCursos() {
        return estudiante.getHistorialCursos();
    }

    public IList<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(IList<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public IList<Curso> getListaCurso() {
        return listaCurso;
    }

    public void setListaCurso(IList<Curso> listaCurso) {
        this.listaCurso = listaCurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
