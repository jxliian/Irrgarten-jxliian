/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava.UI;

import irrgartenjaava.Directions;
import irrgartenjaava.GameState;
import java.util.Scanner;


/**
 *
 * @author jxlig0d
 * 
 *  Implementa UI P5
 * 
 */
public class TextUI implements UI{
    
    private static Scanner in = new Scanner(System.in);
    
    private char readChar() {
        String s = in.nextLine();     
        return s.charAt(0);
    }
    
    @Override
    public Directions nextMove() {
        System.out.print("Where? ");
        
        Directions direction = Directions.DOWN;
        boolean gotInput = false;
        
        while (!gotInput) {
            char c = readChar();
            switch(c) {
                case 'w':
                    System.out.print(" UP\n");
                    direction = Directions.UP;
                    gotInput = true;
                    break;
                case 's':
                    System.out.print(" DOWN\n");
                    direction = Directions.DOWN;
                    gotInput = true;
                    break;
                case 'd':
                    System.out.print("RIGHT\n");
                    direction = Directions.RIGHT;
                    gotInput = true;
                    break;
                case 'a':
                    System.out.print(" LEFT\n");
                    direction = Directions.LEFT;
                    gotInput = true;
                    break;
            }
        }
        return direction;
    }
    //show game prueba
    @Override
    public void showGame(GameState gameState) {  
        
        System.out.print(gameState.getLabyrinth() + "\n");
        System.out.print(gameState.getPlayers() + "\n");
        System.out.print(gameState.getMonsters() + "\n");
        System.out.print("Log:\n" + gameState.getLog() + "\n");
                
        if (gameState.isWinner()) {
            System.out.print("We have a winner! Player " + gameState.getCurrentPlayer() + "\n");
        }else{
            System.out.print("Current player: " + gameState.getCurrentPlayer() + "\n");
        }
        
    }

}
