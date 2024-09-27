/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author jxlig0d
 */
public class Irrgartenjaava {

    /**
     * @param args the comman line arguments
     */
    public static void main(String[] args) {
        Weapon espada = new Weapon(0,0);
        Shield escudo = new Shield(2,3);
        
        espada.attack();
        escudo.protect();
        System.out.println(escudo.toString());
        System.out.println(espada.toString());

        
    }
    
}
