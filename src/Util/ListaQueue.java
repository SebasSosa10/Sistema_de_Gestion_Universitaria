package Util;

import java.io.Serializable;

/**
 *
 * @author JOAN
 */
public class ListaQueue<T> implements IQueue<T>, Serializable{

    private Nodo<T> primero;

    public ListaQueue() {
        this.primero = null;
    }

    @Override
    public void enQueue(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo<T> aux = primero;
            while (aux.nodoSiguiente != null) {
                aux = aux.nodoSiguiente;
            }
            aux.nodoSiguiente = nuevo;
        }
    }

    @Override
    public T deQueue() {
        T dato = primero.dato;
        this.primero = this.primero.nodoSiguiente;
        return dato;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            return this.primero.dato;
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.primero == null){
            return true;
        }
        return false;
    }
}
