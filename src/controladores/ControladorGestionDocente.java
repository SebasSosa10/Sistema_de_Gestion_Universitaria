package controladores;

import Util.IList;
import Util.Lista;
import java.time.LocalDate;
import modelo.Curso;
import modelo.Docente;
import modelo.NumRol;
import modelo.Persona;
import modelo.Usuario;

/**
 *
 * @author JOAN
 */
public class ControladorGestionDocente {

    private Docente docente;
    private IList<Persona> listaPersona;
    private IList<Curso> listaCurso;

    public ControladorGestionDocente(Usuario usuario) {
        this.docente = (Docente) usuario;
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
        this.listaCurso = serializadora.Singleton.getSc().getCurso();
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

    public IList<Curso> getCursosActuales() {
        return docente.getCursosActuales();
    }

    public IList<Curso> getHistorialCursos() {
        return docente.getHistorialCursos();
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Docente buscarDocente(Usuario usuario) {
        for (int i = 0; i < listaPersona.size(); i++) {
            if (listaPersona.get(i).getRol().equals(NumRol.DOCENTE)) {
                Docente aux = (Docente) listaPersona.get(i);
                if (aux.getUsuario().equals(usuario.getUsuario())) {
                    return aux;
                }
            }
        }
        return null;
    }

    public IList<Curso> buscarCursoDocente(Usuario usuario) {
        IList<Curso> listaAux = new Lista<>();
        Docente aux = buscarDocente(usuario);
        if (aux != null) {
            for (int i = 0; i < listaCurso.size(); i++) {
                if (listaCurso.get(i).getDocente().getCodigo().equals(aux.getCodigo())) {
                    if (listaCurso.get(i).getPeriodo().equals(calcularPeriodo())) {
                        listaAux.add(listaCurso.get(i));
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
}
