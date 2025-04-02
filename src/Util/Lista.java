package Util;

import java.io.Serializable;

/**
 *
 * @author JOAN
 */
public class Lista<T> implements IList<T>, Serializable { // define el tipo de dato desde la clase

    private int size;
    private Nodo<T> primero;

    public Lista() {
        this.primero = null;
        this.size = 0;
    }

    @Override
    public void add(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato); // contenedor 'nuevo' vacio
        if (primero == null) { // if(isEmpty())  si el sigiente nodo es vacio se agrega 
            this.primero = nuevo;  //nodoprimero agg al 'nuevo' contenedor
        } else {
            Nodo<T> observador = primero;  // aux para que me ayude a observar al siguiente
            while (observador.nodoSiguiente != null) {  // si ese observador el null se agg si no sigue su recorrido
                observador = observador.nodoSiguiente;  // avanza al siguiente nodo
            }
            observador.nodoSiguiente = nuevo;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {    // si el indice es menor a 0 o menor al tamaño
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (index == 0) {
                return primero.dato;
            } else {
                Nodo<T> observadoNodo = primero;    // es un nodo auxiliar que nos ayuda a ver la posicion que sigue
                int contador = 0;
                while (contador < index) {    // si contador es menor al indice se sigue moviendo de nodo
                    observadoNodo = observadoNodo.nodoSiguiente;   // se mueve el nodo;
                    contador++;
                }
                return observadoNodo.dato;     // retorna lo que el nodo tiene
            }
        }
    }

    @Override
    public void add(T dato, int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Nodo<T> aux = new Nodo<>(dato); // nodo nuevo
            if (index == 0) {
                aux.nodoSiguiente = primero;
                primero = aux;
            } else {
                Nodo<T> aux1 = primero;
                int contador = 0;
                while (contador < index-1) {
                    aux1 = aux1.nodoSiguiente;
                    contador++;
                }
                aux.nodoSiguiente = aux1.nodoSiguiente;
                aux1.nodoSiguiente = aux;
            }
            size++;
        }
    }
    
    @Override
    public void remove(T dato) {
        if (primero.dato == dato) {
            primero = primero.nodoSiguiente;
        } else {
            Nodo <T> aux = primero;
            while (aux.nodoSiguiente.dato != dato) {
                aux = aux.nodoSiguiente;
            }
            aux.nodoSiguiente = aux.nodoSiguiente.nodoSiguiente;

        }
        size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
