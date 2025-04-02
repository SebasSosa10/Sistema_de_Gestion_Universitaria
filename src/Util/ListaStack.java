package Util;

import java.io.Serializable;

/**
 *
 * @author JOAN
 */
public class ListaStack<T> implements Istack<T>, Serializable {

    private Nodo<T> primero;

    public ListaStack() {
        this.primero = null;
    }

    @Override
    public boolean isEmpty() {
        if (this.primero == null) {
            return true;
        }
        return false;
    }

    @Override
    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            nuevo.nodoSiguiente = primero;
            primero = nuevo;
        }
    }

    @Override
    public T pop() {
        T dato = primero.dato;
        this.primero = this.primero.nodoSiguiente;
        return dato;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return this.primero.dato;
        }
    }
}
