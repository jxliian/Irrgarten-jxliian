/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package irrgartenjaava.UI;


import irrgartenjaava.Directions;
import irrgartenjaava.GameState;


/**
 *
 * @author jxlig0d P5
 */
public interface UI {
    
    // Este metodo ya lo realiza la interfaz de usuario de texto
    // luego esta solo realiza la interfaz
    public Directions nextMove();
    
    // Este metodo ya lo realiza la interfaz de usuario de texto
    // luego esta solo realiza la interfaz
    public void showGame(GameState gameState);

}
