/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author JOAN
 */
public class PorcentajenoesigualTotalExepcion extends Exception{

    public PorcentajenoesigualTotalExepcion() {       
        super("no puede salir por que la suma de las notas no es el 100%");
    }
    
    
}
