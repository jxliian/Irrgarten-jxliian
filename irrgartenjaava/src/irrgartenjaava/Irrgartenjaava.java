/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package irrgartenjaava;


import irrgartenjaava.controller.Controller;
import irrgartenjaava.UI.TextUI;

import java.util.ArrayList;

/**
 *
 * @author jxlig0d
 */
public class Irrgartenjaava {

    
    
    /**
     * @param args the comman line arguments
     */
    public static void main(String[] args) {
     
/*   
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
        // Crear instancias de Weapon y probarlas :)
        Weapon espada1 = new Weapon(1, 1); // Potencia 5, 1 uso
        Weapon espada2 = new Weapon(1, 2); // Potencia 3, 2 usos

        // Crear instancias de Shield """
        Shield escudo1 = new Shield(4, 3); // Protección 4, 3 usos
        Shield escudo2 = new Shield(2, 1); // Protección 2, 1 uso

        // Probar los métodos de Weapon y sacarlas por consola :))
        System.out.println("Ataque con espada 1: " + espada1.attack());
        System.out.println("Ataque con espada 2: " + espada2.attack());

        // Probar los métodos de Shield """
        System.out.println("Protección con escudo 1: " + escudo1.protect());
        System.out.println("Protección con escudo 2: " + escudo2.protect());

        // Probar la clase Dice haciendo lo de los 100 intentos xdd
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
    
//----------------------------------------------------------------------------------- parte 3 enumerados

    // Probar los diferentes archivos de enumerados que hemos creado

    Directions direccion = Directions.UP;
    System.out.println("Dirección: " + direccion);

    Orientation orientacion = Orientation.VERTICAL;
    System.out.println("Orientación: " + orientacion);

    GameCharacter jugador = GameCharacter.PLAYER;
    System.out.println("Personaje: " + jugador);

//----------------------------------------------------------------------------------- parte 4 GameState

    // Crear una instancia de GameState y probarla

    GameState estado = new GameState("Laberinto", "Jugadores", "Monstruos", 0, false, "Log");
    System.out.println("game estate" + estado);
    
    
//----------------------------------------------------------------------------------- pruebas para examen
//---------- prueba de player

    Player jugador1= new Player('1', 2, 4);
    Player jugador2= new Player('2', 3, 5);
    //numero, intelligence y fuerza
    System.out.println("Jugador creado:" + jugador1.toString());
    System.out.println("Jugador creado:" + jugador2.toString());
    
    jugador1.setPos(1, 1);
    System.out.println("Jugador1 setposeado a 1,1: " + jugador1.toString());
    // jugador2 ataca
    jugador2.attack();
    System.out.println(
        "col : " +jugador2.getCol() + "row : " +jugador2.getRow() + "number : " +jugador2.getNumber());
    System.out.println("Jugador2 ataca: " + jugador2.toString());
    jugador2.resurrect();
    System.out.println("Jugador2 resurrect: " + jugador2.toString());
    System.out.println("Jugador2 esta muerto?: " + jugador2.dead());

//---------- prueba de monster

    //name, intelligence y strength
    Monster monster1= new Monster("2", 2f, 3f);
    Monster monster2= new Monster("3", 2f, 3f);
    System.out.println("Monstruo creado:" + monster1.toString());
    System.out.println("fuerza: " + monster1.getStrength());
    monster1.setPos(1,2);
    System.out.println("Monster1 setposeado a 1,2: " + monster1.toString());
    
    
//---------- prueba de labyrinth

    // row , col , exitrow, exitcol
    Labyrinth laberinto= new Labyrinth(10,10, 9, 9);
    System.out.println("Laberinto creado:" + '\n' + laberinto.toString());
    System.out.println("Laberinto haveawinner?:" + laberinto.haveAWinner());
    laberinto.addMonster(3,3, monster2);
    System.out.println("Monstruo puesto en laberinto 3,3:" + monster2.toString());
    System.out.println("Laberinto despues del monstruo:" + '\n' + laberinto.toString());

    // resto de cosas de monster son private
    
//---------- prueba de game - no puedo hacer aun me faltan funciones
                // elementales
     
    // ME DA ERROR AQUI pero es normal porque no puedo sacar informacion de GAme, pues para la P2 no esta terminada.
    // nplayer
    //Game juego= new Game(3);
    //System.out.println("Jugador creado:" + juego.getGameState());
    
       
    */
//------------------------------------------------------ inicializacion del juego

    
        final int N_PLAYERS = 1;

        TextUI vista= new TextUI();
        Game juego = new Game(N_PLAYERS);
        Controller controlador = new Controller(juego,vista);

        controlador.play();

    }        
}
   
