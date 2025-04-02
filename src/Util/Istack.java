package Util;

/**
 *
 * @author JOAN
 */
public interface Istack <T> {
    
    public boolean isEmpty();
    
    public void push(T dato);
    
    public T pop();
    
    public T peek();
    
}
