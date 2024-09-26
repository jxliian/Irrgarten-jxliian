/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Irrgarten;

/**
 *
 * @author julian
 */
public class Irrgarten {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Weapon sword = new Weapon(2.0f, 5);
        
        // Usar System.out.println, que llama automáticamente a toString()
        System.out.println(sword); // Imprime: W[2.0, 5]
        
        // Usar el método attack
        System.out.println("Attack power: " + sword.attack()); // Imprime: Attack power: 2.0
        System.out.println(sword); // Imprime: W[2.0, 4]

        // Conversión explícita a cadena
        String weaponString = String.valueOf(sword); // Llama a sword.toString()
        System.out.println(weaponString); // Imprime: W[2.0, 4]    }
    
}
