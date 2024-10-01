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
        Dice dados = new Dice();
        
        // Probar el método discard para el arma y el escudo
        boolean discardEspada = espada.discard(dados); // Comprobar si se descarta el arma
        boolean discardEscudo = escudo.discard(dados); // Comprobar si se descarta el escudo

        // Mostrar el resultado de si el arma y el escudo se descartan
        System.out.println("¿Se descarta el arma? " + (discardEspada ? "Sí" : "No"));
        System.out.println("¿Se descarta el escudo? " + (discardEscudo ? "Sí" : "No"));
        
        boolean resultado= dados.discardElement(5);
        espada.attack();
        escudo.protect();
        System.out.println(resultado);
        System.out.println(escudo.toString());
        System.out.println(espada.toString());
        
        //--------------------------------------------------------------------------------------------- parte 2 main
        // Crear instancias de Weapon
        Weapon espada1 = new Weapon(1, 1); // Potencia 5, 1 uso
        Weapon espada2 = new Weapon(1, 2); // Potencia 3, 2 usos

        // Crear instancias de Shield
        Shield escudo1 = new Shield(4, 3); // Protección 4, 3 usos
        Shield escudo2 = new Shield(2, 1); // Protección 2, 1 uso

        // Probar los métodos de Weapon
        System.out.println("Ataque con espada 1: " + espada1.attack());
        System.out.println("Ataque con espada 2: " + espada2.attack());

        // Probar los métodos de Shield
        System.out.println("Protección con escudo 1: " + escudo1.protect());
        System.out.println("Protección con escudo 2: " + escudo2.protect());

        // Probar la clase Dice
        int totalDescartes = 0;
        for (int i = 0; i < 100; i++) {
            int usesLeft = dados.usesLeft();
            boolean discard = dados.discardElement(usesLeft);
            if (discard) {
                totalDescartes++;
            }
            System.out.println("Descartar elemento: " +i+ " con " + usesLeft + " usos restantes: " + (discard ? "Sí" : "No"));
        }

        System.out.println("Total de descartes en 100 intentos: " + totalDescartes);
    }
        

        
    }
   
