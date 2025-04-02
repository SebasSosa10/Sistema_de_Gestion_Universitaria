package controladores;

import Exepciones.DescripcionIgualExepcion;
import Exepciones.NoTieneCursosIncritosExepcion;
import Exepciones.NoseleHaAsignaCursoAlDocenteExepcion;
import Exepciones.NotaNoEncontradaExepcion;
import Exepciones.PorcentajeExcedeElTotalExepcion;
import Exepciones.PorcentajeNoCompletaElTotalExepcion;
import Exepciones.PorcentajenoesigualTotalExepcion;
import Exepciones.SoloPuedeGuardar3NotasExepcion;
import Util.IList;
import modelo.Curso;
import modelo.Nota;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorNotas {

    private IList<Curso> listaCurso;

    public ControladorNotas() {
        this.listaCurso = Singleton.getSc().getCurso();
    }

    public IList<Curso> getListaCurso() {
        return listaCurso;
    }

    public Nota buscarNota(Curso curso, String descripcion) {
        for (int i = 0; i < curso.getListaNotas().size(); i++) {
            if (descripcion.equals(curso.getListaNotas().get(i).getDescripcion())) {
                return curso.getListaNotas().get(i);
            }
        }
        return null;
    }

    public Curso validarCurso(String curso) {
        for (int i = 0; i < listaCurso.size(); i++) {
            if (curso.equals(listaCurso.get(i).getCodigoCurso())) {
                return listaCurso.get(i);
            }
        }
        return null;
    }

    public void guardarNota(Curso curso, Nota nota) throws PorcentajeExcedeElTotalExepcion, NoTieneCursosIncritosExepcion, SoloPuedeGuardar3NotasExepcion, PorcentajeNoCompletaElTotalExepcion, DescripcionIgualExepcion {
        Curso aux = validarCurso(curso.getCodigoCurso());
        if (aux == null) {
            throw new NoTieneCursosIncritosExepcion();
        }
        if (aux.getListaNotas().size() >= 3) {
            throw new SoloPuedeGuardar3NotasExepcion();
        }
        validarDescripcionUnica(aux, nota);
        validarPorcentaje(curso, nota);
        aux.getListaNotas().add(nota);
        serializadora.Singleton.getSc().escribirListaCurso();
    }

    public void ModificarNota(Curso curso, Nota nota) throws PorcentajeExcedeElTotalExepcion, NoTieneCursosIncritosExepcion, SoloPuedeGuardar3NotasExepcion, NotaNoEncontradaExepcion, PorcentajeNoCompletaElTotalExepcion {
        Curso aux = validarCurso(curso.getCodigoCurso());
        if (aux == null) {
            throw new NoTieneCursosIncritosExepcion();
        }
        Nota aux1 = buscarNota(curso, nota.getDescripcion());
        if (aux1 == null) {
            throw new NotaNoEncontradaExepcion();
        }
        double totalPercentage = calculateTotalPorcentaje(aux, aux1);
        validarCondicion(aux, totalPercentage, nota.getPorcenta());
        aux1.setDescripcion(nota.getDescripcion());
        aux1.setPorcenta(nota.getPorcenta());
        serializadora.Singleton.getSc().escribirListaCurso();
    }

    private double calculateTotalPorcentaje(Curso curso, Nota nota) {
        double total = 0;
        for (int i = 0; i < curso.getListaNotas().size(); i++) {
            Nota aux = curso.getListaNotas().get(i);
            if (aux != nota) {
                total += aux.getPorcenta();
            }
        }
        return total;
    }

    private void validarDescripcionUnica(Curso curso, Nota nota) throws DescripcionIgualExepcion {
        Curso aux = validarCurso(curso.getCodigoCurso());
        for (int i = 0; i < aux.getListaNotas().size(); i++) {
            if (aux.getListaNotas().get(i).getDescripcion().equals(nota.getDescripcion())) {
                throw new DescripcionIgualExepcion();
            }
        }
    }

    private void validarCondicion(Curso curso, double TotalPorcentaje, double NotaPorcentaje) throws PorcentajeExcedeElTotalExepcion, SoloPuedeGuardar3NotasExepcion, PorcentajeNoCompletaElTotalExepcion {
        int numNotas = curso.getListaNotas().size();
        if (numNotas == 3 && TotalPorcentaje == 0) {
            throw new SoloPuedeGuardar3NotasExepcion();
        }
        if (TotalPorcentaje + NotaPorcentaje > 100) {
            throw new PorcentajeExcedeElTotalExepcion();
        }
        if (numNotas == 3 && TotalPorcentaje + NotaPorcentaje != 100) {
            throw new PorcentajeNoCompletaElTotalExepcion();
        }
    }

    public void validarPorcentaje(Curso curso, Nota nota) throws PorcentajeNoCompletaElTotalExepcion, PorcentajeExcedeElTotalExepcion {
        double notaFinal = 0;
        int numNotas = curso.getListaNotas().size();
        for (int i = 0; i < numNotas; i++) {
            notaFinal += curso.getListaNotas().get(i).getPorcenta();
        }
        if (notaFinal + nota.getPorcenta() > 100) {
            throw new PorcentajeExcedeElTotalExepcion();
        }
        if (numNotas == 2 && notaFinal + nota.getPorcenta() != 100) {
            throw new PorcentajeNoCompletaElTotalExepcion();
        }
    }

    public void eliminarNota(Curso curso, Nota nota) throws NoTieneCursosIncritosExepcion, NotaNoEncontradaExepcion {
        Curso aux = validarCurso(curso.getCodigoCurso());
        if (aux == null) {
            throw new NoTieneCursosIncritosExepcion();
        }
        Nota notaAEliminar = buscarNota(aux, nota.getDescripcion());
        if (notaAEliminar == null) {
            throw new NotaNoEncontradaExepcion();
        }
        IList<Nota> listaNotas = aux.getListaNotas();
        int initialSize = listaNotas.size();
        listaNotas.remove(notaAEliminar);
        int finalSize = listaNotas.size();
        if (initialSize == finalSize) {
            throw new NotaNoEncontradaExepcion();
        }
        Singleton.getSc().escribirListaCurso();
    }

    public void validarSalida(Curso curso) throws PorcentajenoesigualTotalExepcion, NoseleHaAsignaCursoAlDocenteExepcion {
        double porcentaje = 0;
        Curso aux = validarCurso(curso.getCodigoCurso());
        if (aux != null) {
            for (int i = 0; i < aux.getListaNotas().size(); i++) {
                porcentaje += aux.getListaNotas().get(i).getPorcenta();
            }
            if (porcentaje != 100) {
                throw new PorcentajenoesigualTotalExepcion();
            }
        } else {
            throw new NoseleHaAsignaCursoAlDocenteExepcion();
        }
    }
}
