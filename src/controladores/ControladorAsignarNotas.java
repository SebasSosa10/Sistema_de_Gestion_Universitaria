package controladores;

import Exepciones.NotaMayorExepcion;
import Exepciones.NotaMenorExepcion;
import Exepciones.YaSeCalificoLaNotaExepcion;
import Util.IList;
import modelo.Curso;
import modelo.DetalleNota;
import modelo.Estudiante;
import modelo.Nota;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorAsignarNotas {

    private IList<Curso> listaCurso;

    public ControladorAsignarNotas() {
        this.listaCurso = Singleton.getSc().getCurso();
    }

    public IList<Curso> getListaCurso() {
        return listaCurso;
    }

    public void guardarNota(Curso curso, Nota nota, double valor, Estudiante estudiante) throws NotaMayorExepcion, NotaMenorExepcion, YaSeCalificoLaNotaExepcion {
        Curso aux = validarCurso(curso.getCodigoCurso());
        boolean aux2 = validarNota(valor);
        if (aux != null) {
            if (aux2) {
                for (int i = 0; i < curso.getListaNotas().size(); i++) {
                    if (curso.getListaNotas().get(i).getDescripcion().equals(nota.getDescripcion())) {
                        Nota aux3 = curso.getListaNotas().get(i);
                        for (int j = 0; j < aux3.getListaDetalle().size(); j++) {
                            if (estudiante.getCodigo().equals(aux3.getListaDetalle().get(j).getEstudiante().getCodigo())) {
                                if (aux3.getListaDetalle().get(j).isCalifacdo() == false) {
                                    aux3.getListaDetalle().get(j).setValor(valor);
                                    aux3.getListaDetalle().get(j).setCalifacdo(true);
                                    serializadora.Singleton.getSc().escribirListaCurso();
                                } else {
                                    throw new YaSeCalificoLaNotaExepcion();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void ModificarNota(Curso curso, Nota nota, double valor, Estudiante estudiante) {
        Curso aux = validarCurso(curso.getCodigoCurso());
        boolean aux2 = validarNota(valor);
        if (aux != null) {
            if (aux2) {
                for (int i = 0; i < curso.getListaNotas().size(); i++) {
                    if (curso.getListaNotas().get(i).getDescripcion().equals(nota.getDescripcion())) {
                        Nota aux3 = curso.getListaNotas().get(i);
                        for (int j = 0; j < aux3.getListaDetalle().size(); j++) {
                            if (estudiante.getCodigo().equals(aux3.getListaDetalle().get(j).getEstudiante().getCodigo())) {
                                aux3.getListaDetalle().get(j).setValor(valor);
                                aux3.getListaDetalle().get(j).setCalifacdo(true);
                                serializadora.Singleton.getSc().escribirListaCurso();
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean validarNota(double valor) throws NotaMayorExepcion, NotaMenorExepcion {
        if (valor >= 0) {
            if (valor <= 5) {
                return true;
            } else {
                throw new NotaMayorExepcion();
            }
        } else {
            throw new NotaMenorExepcion();
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

    public String calcularPorcentajeTotal(Curso curso, Estudiante estudiante) {
        double total = 0;
        for (int i = 0; i < curso.getListaNotas().size(); i++) {
            for (int j = 0; j < curso.getListaNotas().get(i).getListaDetalle().size(); j++) {
                Nota nota = curso.getListaNotas().get(i);
                DetalleNota detalle = curso.getListaNotas().get(i).getListaDetalle().get(j);
                if (detalle.getEstudiante().getCodigo().equals(estudiante.getCodigo())) {
                    total += detalle.getValor() * nota.getPorcenta();
                }
            }
        }
        return String.valueOf(total / 100);
    }

}
