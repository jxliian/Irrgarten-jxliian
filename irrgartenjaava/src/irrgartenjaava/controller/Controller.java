/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava.controller;

import irrgartenjaava.Directions;
import irrgartenjaava.Game;
import irrgartenjaava.UI.*; // para añadir todos


/**
 *
 * @author jxlig0d
 */
public class Controller {
    
    private Game game;
    private UI view;
    
    public Controller(Game game, UI view) {
        this.game = game;
        this.view = view;
    }
    
    public void play() {
        boolean endOfGame = false;
        while (!endOfGame) {
            view.showGame(game.getGameState()); 
            Directions direction = view.nextMove(); 
            endOfGame = game.nextStep(direction);
        }
      view.showGame(game.getGameState());        
    }
    
}