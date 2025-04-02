/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 *
 * @author JOAN
 */
public class SoloUnaReservaExepcion extends Exception{

    public SoloUnaReservaExepcion() {
        super("Ya tiene una reserva activa");
    }
    
    
}
