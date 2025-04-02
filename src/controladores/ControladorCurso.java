package controladores;

import Exepciones.CruzanHorariosEstudianteExepcion;
import Exepciones.ElEstudianteNoesDeEsteProgramaExepcion;
import Exepciones.EstudianteNoExisteExepcion;
import Exepciones.EstudianteNoSeEliminoDelCursoExepcion;
import Exepciones.EstudianteYaExisteEnElCursoExepcion;
import Exepciones.NoExisteElIdExepcion;
import Exepciones.NoSeEncuentraElCursoParaEliminarExepcion;
import Exepciones.NoSeGuardoElCursoExepcion;
import Exepciones.NoSeModificoElCursoExepcion;
import Exepciones.SoloPuedeHaberUnCursoConEsaJornadaExepcion;
import Exepciones.YaExisteUnCursoGuardadoConEstasMismasCaracteristicasExepcion;
import Util.IList;
import Util.IQueue;
import Util.Istack;
import Util.Lista;
import Util.ListaQueue;
import Util.ListaStack;
import java.awt.List;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Accion;
import modelo.Curso;
import modelo.DetalleNota;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Horario;
import modelo.Materia;
import modelo.Nota;
import modelo.NumRol;
import modelo.Persona;
import modelo.Programa;
import modelo.Usuario;
import serializadora.Singleton;

/**
 *
 * @author JOAN
 */
public class ControladorCurso {

    private IList<Persona> listaPersona;
    private IList<Curso> listaCurso;
    private IList<Materia> listaMateria;
    private IList<Programa> listaPrograma;
    private Istack<Accion> pila1;
    private Istack<Accion> pila2;

    public ControladorCurso() {
        this.listaPersona = serializadora.Singleton.getSc().getPersona();
        this.listaCurso = serializadora.Singleton.getSc().getCurso();
        this.listaMateria = serializadora.Singleton.getSc().getMateria();
        this.listaPrograma = serializadora.Singleton.getSc().getPrograma();
        pila1 = new ListaStack<>();
        pila2 = new ListaStack<>();
        if (listaMateria.isEmpty()) {
            inicializarMaterias();
        }
        if (listaPrograma.isEmpty()) {
            inicializarPrograma();
        }
        actualizarEstado();
    }

    public IList<Persona> getListaPersona() {
        return listaPersona;
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

    public void inicializarMaterias() {
        Materia lenguajeProgramacion = new Materia("Lenguaje de Programación", "LP");
        Materia estructuras = new Materia("Estructuras", "EST");
        Materia programacionWeb = new Materia("Programación Web", "WEB");
        Materia quimica = new Materia("Química", "QMC");
        Materia quimicaOrganica = new Materia("QuímicaOrganica", "QMC");
        Materia biologiaAtomica = new Materia("Biologia Atomica", "QMC");
        Materia mecanica = new Materia("Mecanica", "MEC");
        Materia electromagnetismo = new Materia("Electromagnetismo", "ELEC");
        Materia termodinamica = new Materia("Termodinamica", "TERMO");
        Materia calculoDiferencial = new Materia("Cálculo Diferencial", "CALDIF");
        Materia calculoIntegral = new Materia("Cálculo Integral", "CALINT");
        Materia calculoVectorial = new Materia("Cálculo Vectorial", "CALVEC");
        Materia ecuacionDiferencial = new Materia("Ecuaciones Diferenciales", "ECUDIF");
        Materia algebraLineal = new Materia("Álgebra Lineal", "ALGLIN");
        Materia geometria = new Materia("Geometria", "GMA");
        Materia geometriaAnalitica = new Materia("GeometriaAnalica", "GMAANA");
        Materia espaniol = new Materia("Español", "ESP");
        Materia etica = new Materia("Ética", "ETC");
        Materia diseno = new Materia("Diseño", "DIS");

        listaMateria.add(lenguajeProgramacion); //0
        listaMateria.add(quimica);//1
        listaMateria.add(quimicaOrganica);//2
        listaMateria.add(biologiaAtomica);//3
        listaMateria.add(mecanica);//4
        listaMateria.add(electromagnetismo);//5
        listaMateria.add(termodinamica);//6
        listaMateria.add(geometria);//7
        listaMateria.add(espaniol);//
        listaMateria.add(etica);//0
        listaMateria.add(diseno);//0
        listaMateria.add(estructuras);//0
        listaMateria.add(programacionWeb);//0
        listaMateria.add(calculoDiferencial);//0
        listaMateria.add(calculoIntegral);//0
        listaMateria.add(calculoVectorial);//0
        listaMateria.add(ecuacionDiferencial);//0
        listaMateria.add(algebraLineal);//0
        listaMateria.add(geometriaAnalitica);//0
        serializadora.Singleton.getSc().escribirListaMateria();
    }

    public void inicializarPrograma() {
        Programa ingenieriaSofware = new Programa("Ingeniería de Software", "IS");
        ingenieriaSofware.agregarMateria(listaMateria.get(0));
        ingenieriaSofware.agregarMateria(listaMateria.get(4));
        ingenieriaSofware.agregarMateria(listaMateria.get(5));
        ingenieriaSofware.agregarMateria(listaMateria.get(11));
        ingenieriaSofware.agregarMateria(listaMateria.get(12));
        ingenieriaSofware.agregarMateria(listaMateria.get(13));
        ingenieriaSofware.agregarMateria(listaMateria.get(14));
        listaPrograma.add(ingenieriaSofware);
        Programa quimica = new Programa("Química", "QMC");
        quimica.agregarMateria(listaMateria.get(1));
        quimica.agregarMateria(listaMateria.get(2));
        quimica.agregarMateria(listaMateria.get(4));
        quimica.agregarMateria(listaMateria.get(5));
        quimica.agregarMateria(listaMateria.get(8));
        listaPrograma.add(quimica);
        Programa fisica = new Programa("Física", "FIS");
        fisica.agregarMateria(listaMateria.get(4));
        fisica.agregarMateria(listaMateria.get(5));
        fisica.agregarMateria(listaMateria.get(6));
        fisica.agregarMateria(listaMateria.get(7));
        fisica.agregarMateria(listaMateria.get(13));
        fisica.agregarMateria(listaMateria.get(14));
        fisica.agregarMateria(listaMateria.get(15));
        fisica.agregarMateria(listaMateria.get(17));
        listaPrograma.add(fisica);
        Programa ingenieriaSistemas = new Programa("Ingeniería de Sistemas", "ISI");
        ingenieriaSistemas.agregarMateria(listaMateria.get(0));
        ingenieriaSistemas.agregarMateria(listaMateria.get(4));
        ingenieriaSistemas.agregarMateria(listaMateria.get(5));
        ingenieriaSistemas.agregarMateria(listaMateria.get(11));
        ingenieriaSistemas.agregarMateria(listaMateria.get(12));
        ingenieriaSistemas.agregarMateria(listaMateria.get(13));
        ingenieriaSistemas.agregarMateria(listaMateria.get(14));
        listaPrograma.add(ingenieriaSistemas);
        Programa administracionNegocio = new Programa("Administración de Negocios", "ADM");
        administracionNegocio.agregarMateria(listaMateria.get(14));
        administracionNegocio.agregarMateria(listaMateria.get(15));
        administracionNegocio.agregarMateria(listaMateria.get(16));
        administracionNegocio.agregarMateria(listaMateria.get(17));
        administracionNegocio.agregarMateria(listaMateria.get(18));
        listaPrograma.add(administracionNegocio);
        Programa contaduriaPublica = new Programa("Contaduría Pública", "CP");
        contaduriaPublica.agregarMateria(listaMateria.get(11));
        contaduriaPublica.agregarMateria(listaMateria.get(12));
        contaduriaPublica.agregarMateria(listaMateria.get(13));
        contaduriaPublica.agregarMateria(listaMateria.get(14));
        contaduriaPublica.agregarMateria(listaMateria.get(15));
        contaduriaPublica.agregarMateria(listaMateria.get(16));
        contaduriaPublica.agregarMateria(listaMateria.get(17));
        contaduriaPublica.agregarMateria(listaMateria.get(18));
        listaPrograma.add(contaduriaPublica);
        Programa ingenieriaMecatronica = new Programa("Ingeniería Mecatrónica", "MECA");
        ingenieriaMecatronica.agregarMateria(listaMateria.get(4));
        ingenieriaMecatronica.agregarMateria(listaMateria.get(10));
        ingenieriaMecatronica.agregarMateria(listaMateria.get(11));
        ingenieriaMecatronica.agregarMateria(listaMateria.get(12));
        ingenieriaMecatronica.agregarMateria(listaMateria.get(13));
        ingenieriaMecatronica.agregarMateria(listaMateria.get(14));
        listaPrograma.add(ingenieriaMecatronica);
        serializadora.Singleton.getSc().escribirListaPrograma();
    }

    public IList<Materia> getListaMateria() {
        return listaMateria;
    }

    public IList<Programa> getListaPrograma() {
        return listaPrograma;
    }

    // ------------------------- CRUD  --------------------------------
    public Curso buscarCurso(String codigo) {
        for (int i = 0; i < listaCurso.size(); i++) {
            if (codigo.equals(listaCurso.get(i).getCodigoCurso())) {
                return listaCurso.get(i);
            }
        }
        return null;
    }

    public void guardarCurso(Curso curso) throws NoSeGuardoElCursoExepcion, YaExisteUnCursoGuardadoConEstasMismasCaracteristicasExepcion, SoloPuedeHaberUnCursoConEsaJornadaExepcion {
        Curso aux = buscarCurso(curso.getCodigoCurso());
        boolean aux1 = validarSoloUno(curso);
        if (aux == null) {
            if (aux1) {
                listaCurso.add(curso);
                pila1.push(new Accion("Guardar", curso));
                serializadora.Singleton.getSc().escribirListaCurso();
            } else {
                throw new YaExisteUnCursoGuardadoConEstasMismasCaracteristicasExepcion();
            }
        } else {
            throw new NoSeGuardoElCursoExepcion();
        }
    }

    public boolean validarSoloUno(Curso curso) throws SoloPuedeHaberUnCursoConEsaJornadaExepcion {
        for (int i = 0; i < listaCurso.size(); i++) {
            Curso aux = listaCurso.get(i);
            if (aux.getJornada().equals(curso.getJornada())
                    && aux.getPeriodo().equals(curso.getPeriodo())
                    && aux.getPrograma().equals(curso.getPrograma())
                    && aux.getMateria().equals(curso.getMateria())) {
                if (!aux.getDocente().equals(curso.getDocente())) {
                    throw new SoloPuedeHaberUnCursoConEsaJornadaExepcion();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void eliminarCurso(String codigo) throws NoSeEncuentraElCursoParaEliminarExepcion {
        Curso aux = buscarCurso(codigo);
        if (aux != null) {
            listaCurso.remove(aux);
            pila2.push(new Accion("Eliminar", aux));
            serializadora.Singleton.getSc().escribirListaCurso();
        } else {
            throw new NoSeEncuentraElCursoParaEliminarExepcion();
        }
    }

    public void actualizarEstado() {
        for (int i = 0; i < listaCurso.size(); i++) {
            listaCurso.get(i).actualizarEstado();
        }
        serializadora.Singleton.getSc().escribirListaCurso();
    }

    public void dehacer() {
        if (!pila1.isEmpty()) {
            Accion accion = pila1.pop();
            Curso aux = (Curso) accion.getObjeto();
            if (accion.getAccion().equals("Guardar")) {
                try {
                    eliminarCurso(aux.getCodigoCurso());
                    System.out.println("Se elimino el curso");
                } catch (NoSeEncuentraElCursoParaEliminarExepcion e) {
                    e.printStackTrace();
                }
            } else if (accion.getAccion().equals("Eliminar")) {
                try {
                    guardarCurso(aux);
                    System.out.println("Se guardó el curso");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                pila2.push(accion);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay acciones para deshacer");
        }
    }

    public void rehacer() {
        if (!pila2.isEmpty()) {
            Accion accion = pila2.pop();
            Curso aux = (Curso) accion.getObjeto();
            if (accion.getAccion().equals("Eliminar")) {
                try {
                    guardarCurso(aux);
                    System.out.println("Se guardo el curso");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (accion.getAccion().equals("Guardar")) {
                try {
                    eliminarCurso(aux.getCodigoCurso());
                    System.out.println("Se elimino el curso");
                } catch (NoSeEncuentraElCursoParaEliminarExepcion e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
                pila1.push(accion);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay acciones para rehacer");
        }
    }

    public static String obtenerPeriodoActual() {
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

    // ----------------------------- CRUD GUARDAR ESTUDIANTE A CURSO -----------------------------
    public Estudiante buscarCursoEstud(Curso curso, Estudiante estudiante) {
        for (int i = 0; i < curso.getListaEstudiates().size(); i++) {
            if (curso.getListaEstudiates().get(i).equals(estudiante)) {
                return curso.getListaEstudiates().get(i);
            }
        }
        return null;
    }

    public void guardarCursoEstud(Estudiante estudiante, Curso curso) throws EstudianteYaExisteEnElCursoExepcion, CruzanHorariosEstudianteExepcion {
        Curso aux = buscarCurso(curso.getCodigoCurso());
        boolean aux1 = validarNoSeCruzo(estudiante, curso);
        if (aux != null) {
            if (aux1) {
                aux.guardarEstudiante(estudiante);
                aux.setListaNotas(validarNotas(curso));
                Singleton.getSc().escribirListaCurso();
            } else {
                throw new CruzanHorariosEstudianteExepcion();
            }
        }

    }

    public void modificarCursoEstud(Estudiante estudiante) {
        for (int i = 0; i < listaCurso.size(); i++) {
            for (int j = 0; j < listaCurso.get(i).getListaEstudiates().size(); j++) {
                if (listaCurso.get(i).getListaEstudiates().get(j).getCodigo().equals(estudiante.getCodigo())) {
                    Estudiante aux = listaCurso.get(i).getListaEstudiates().get(j);
                    aux.setNombre(estudiante.getNombre());
                    aux.setTelefono(estudiante.getTelefono());
                    aux.setDireccion(estudiante.getDireccion());
                    aux.setPrograma(estudiante.getPrograma());
                    aux.setSemestre(estudiante.getSemestre());
                    aux.setGenero(estudiante.getGenero());
                    aux.setCorreo(estudiante.getCorreo());
                    aux.setFechaNacimiento(estudiante.getFechaNacimiento());
                    aux.setEdad(estudiante.calcularEdad());
                    Singleton.getSc().escribirListaCurso();
                }
            }
        }
    }

    public void eliminarCursoEstud(Curso curso, Estudiante estudiante) throws EstudianteNoSeEliminoDelCursoExepcion {
        for (int i = 0; i < curso.getListaEstudiates().size(); i++) {
            if (curso.getListaEstudiates().get(i).equals(estudiante)) {
                curso.eliminarEstudiante(estudiante);
                Singleton.getSc().escribirListaCurso();
            } else {
                throw new EstudianteNoSeEliminoDelCursoExepcion();
            }
        }
    }

    public boolean validarNoSeCruzo(Estudiante estudiante, Curso curso) {
        Estudiante aux;
        for (int i = 0; i < listaCurso.size(); i++) {
            aux = listaCurso.get(i).buscarEstudiante(estudiante.getCodigo());
            if (aux != null) {
                for (int j = 0; j < listaCurso.get(i).getListaHorario().size(); j++) {
                    if (ValidarHorarioEstu(curso.getListaHorario(), listaCurso.get(i).getListaHorario())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean ValidarHorarioEstu(IList<Horario> listaHorario1, IList<Horario> listaHorario2) {
        for (int i = 0; i < listaHorario1.size(); i++) {
            Horario horario1 = listaHorario1.get(i);
            for (int j = 0; j < listaHorario2.size(); j++) {
                Horario horario2 = listaHorario2.get(j);
                if (horario1.getDia().equals(horario2.getDia())) {
                    if ((horario1.getHoraMinutoInicio().isBefore(horario2.getHoraMinutoInicio())
                            && horario1.getHoraMinutoFinal().isAfter(horario2.getHoraMinutoInicio()))
                            || horario1.getHoraMinutoInicio().isBefore(horario2.getHoraMinutoFinal())
                            && horario1.getHoraMinutoFinal().isAfter(horario2.getHoraMinutoFinal())
                            || horario1.getHoraMinutoInicio().equals(horario2.getHoraMinutoInicio())
                            || horario1.getHoraMinutoFinal().equals(horario2.getHoraMinutoFinal())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public IList<Nota> validarNotas(Curso curso) {
        IList<Nota> aux = new Lista<>();
        for (int i = 0; i < curso.getListaNotas().size(); i++) {
            aux.add(new Nota(curso.getListaNotas().get(i).getDescripcion(), curso.getListaNotas().get(i).getPorcenta()));
            aux.get(i).notasEstudiante(curso.getListaEstudiates());
        }
        return aux;
    }

}
