/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author JOAN
 */
public class DescripcionIgualExepcion extends Exception{

    public DescripcionIgualExepcion() {
        super("ya exite una nota con esta descripcion");
    }
}
