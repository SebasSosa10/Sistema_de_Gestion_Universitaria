package serializadora;

import Util.IList;
import Util.IQueue;
import Util.Lista;
import Util.ListaQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.Curso;
import modelo.Laboratorio;
import modelo.Mantenimiento;
import modelo.Materia;
import modelo.Nota;
import modelo.Persona;
import modelo.Prestamo;
import modelo.Programa;
import modelo.Reserva;

/**
 *
 * @author JOAN
 */
public class Singleton {

    private static final Singleton INSTANCIA = new Singleton();

    Laboratorio[][] laboratorios;
    IList<Persona> listaPersona;
    IList<Curso> listaCurso;
    IList<Nota> listaNota;
    IList<Materia> listaMateria;
    IList<Programa> listaPrograma;
    IList<Mantenimiento> listaMantenimiento;
    IQueue<Prestamo> colaPrestamo;

    private Singleton() {
        this.laboratorios = leerLaboratorio();
        this.listaPersona = leerListaPersona();
        this.listaCurso = leerListaCurso();
        this.listaNota = leerListaNotas();
        this.listaMateria = leerListaMateria();
        this.listaPrograma = leerListaPrograma();
        this.listaMantenimiento = leerListaMantenimiento();
        this.colaPrestamo = leerColaPrestamo();
    }

    public static Singleton getSc() {
        return INSTANCIA;
    }

    public Laboratorio[][] getLaboratorios() {
        return laboratorios;
    }

    public IList<Persona> getPersona() {
        return listaPersona;
    }

    public IList<Curso> getCurso() {
        return listaCurso;
    }

    public IList<Nota> getNotas() {
        return listaNota;
    }

    public IList<Materia> getMateria() {
        return listaMateria;
    }

    public IList<Programa> getPrograma() {
        return listaPrograma;
    }

    public IList<Mantenimiento> getMantenimiento() {
        return listaMantenimiento;
    }

    public IQueue<Prestamo> getColaPrestamo() {
        return colaPrestamo;
    }

    public void escribirLaboratorio() {
        try {
            FileOutputStream archivo = new FileOutputStream("Laboratorio.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(laboratorios);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Laboratorio[][] leerLaboratorio() {
        try {
            FileInputStream archivo = new FileInputStream("Laboratorio.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Laboratorio[][]) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Laboratorio[][] laboratorios = new Laboratorio[3][];
            laboratorios[0] = new Laboratorio[5];
            laboratorios[1] = new Laboratorio[1];
            laboratorios[2] = new Laboratorio[5];
            return laboratorios;
        }
    }

    public void escribirListaPersona() {
        try {
            FileOutputStream archivo = new FileOutputStream("ListPersona.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaPersona);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IList<Persona> leerListaPersona() {
        try {
            FileInputStream archivo = new FileInputStream("ListPersona.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Lista<Persona>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new Lista<>();
        }
    }

    public void escribirListaCurso() {
        try {
            FileOutputStream archivo = new FileOutputStream("ListCurso.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaCurso);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IList<Curso> leerListaCurso() {
        try {
            FileInputStream archivo = new FileInputStream("ListCurso.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Lista<Curso>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new Lista<>();
        }
    }

    public void escribirListaNotas() {
        try {
            FileOutputStream archivo = new FileOutputStream("ListNotas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaNota);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IList<Nota> leerListaNotas() {
        try {
            FileInputStream archivo = new FileInputStream("ListNotas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Lista<Nota>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new Lista<>();
        }
    }

    public void escribirListaPrograma() {
        try {
            FileOutputStream archivo = new FileOutputStream("ListPrograma.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaPrograma);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IList<Programa> leerListaPrograma() {
        try {
            FileInputStream archivo = new FileInputStream("ListPrograma.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Lista<Programa>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new Lista<>();
        }
    }

    public void escribirListaMateria() {
        try {
            FileOutputStream archivo = new FileOutputStream("ListMateria.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaMateria);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IList<Materia> leerListaMateria() {
        try {
            FileInputStream archivo = new FileInputStream("ListMateria.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Lista<Materia>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new Lista<>();
        }
    }

    public void escribirListaMantenimiento() {
        try {
            FileOutputStream archivo = new FileOutputStream("ListaMantenimiento.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaMantenimiento);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IList<Mantenimiento> leerListaMantenimiento() {
        try {
            FileInputStream archivo = new FileInputStream("ListaMantenimiento.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Lista<Mantenimiento>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new Lista<>();
        }
    }

    public void escribirColaPrestamo() {
        try {
            FileOutputStream archivo = new FileOutputStream("ColaPrestamo.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(colaPrestamo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public IQueue<Prestamo> leerColaPrestamo() {
        try {
            FileInputStream archivo = new FileInputStream("ColaPrestamo.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ListaQueue<Prestamo>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return new ListaQueue<>();
        }
    }

}
