/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author jxlig0d
 */
public class GameState {
    
    private String labyrinth;
    private String players;
    private String monsters;
    private int currentPlayer;
    private boolean winner;
    private String log;
    
    //Constructor
    
    public GameState(String labyrinth, String players, String monsters, int currentPlayer, boolean winner, String log){
        this.labyrinth = labyrinth;
        this.players = players;
        this.monsters = monsters;
        this.currentPlayer = currentPlayer;
        this.winner = winner;
        this.log = log;
        
    }
    
    // Consultor para labyrinth
    public String getLabyrinth() {
        return labyrinth;
    }

    // Consultor para players
    public String getPlayers() {
        return players;
    }

    // Consultor para monsters
    public String getMonsters() {
        return monsters;
    }

    // Consultor para currentPlayer
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    // Consultor para winner
    public boolean isWinner() {
        return winner;
    }

    // Consultor para log
    public String getLog() {
        return log;
    }
    
    
}
