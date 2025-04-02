package Util;

import java.io.Serializable;

/**
 * @author JOAN
 */

public class Nodo <U> implements Serializable{ // el es el mismo objeto de T
    
    U dato;
    Nodo<U> nodoSiguiente;
    
    public Nodo(U dato){
        this.dato = dato;
        this.nodoSiguiente = null; 
    }
}
