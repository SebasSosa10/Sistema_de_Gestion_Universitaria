package Util;

/**
 *
 * @author JOAN
 */
public interface IList <T> {  // <T> son tipo de variables se pueden meter mas <D>,<S>,<U>
    //toma el valor la intervaz de un objeto que seria una clase <T>
    /**
     * add es para agregar un dato a la lista 
     * get es para buscar el dato
     * add es para agg un dato con indice
     * eliminar con el indice
     * longitud de la lists 
     * is empty si esta vacia
     */

    public void add(T dato);   //el tipo de dato ya es un objeto
    
    public T get(int index);  // tambien puede tomar valores de retorno
    
    public void add(T dato, int index);
    
    public void remove(T dato);
    
    public int size();
    
    public boolean isEmpty();
}
