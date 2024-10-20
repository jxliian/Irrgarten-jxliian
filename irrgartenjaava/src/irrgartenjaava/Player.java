/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author jxlig0d
 */
public class Player {
    
    private static final int MAX_WEAPONS=2;
    private static final int MAX_SHIELDS=3;
    private static final int INITIAL_HEALTH=10;
    private static final int HITS2LOSE=3;
    
    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits=0;
    
    Player(char number, float intelligence, float strength){
        throw new UnsupportedOperationException();
    }
    
    public void resurrect(){
        throw new UnsupportedOperationException();
    }
    
    public int getRow(){
        throw new UnsupportedOperationException();
    }

    public int getCol(){
        throw new UnsupportedOperationException();
    }
    
    public char getNumber(){
        throw new UnsupportedOperationException();
    }

    public void setPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public boolean dead(){
        throw new UnsupportedOperationException();
    }
    
    public Directions move(Directions direction, Directions []validMoves){
        throw new UnsupportedOperationException(); // se hace asi???
    }                                              // directions [] me refiero
    
    public float attack(){
        throw new UnsupportedOperationException();
    }
    
    public boolean defend(float receivedAttack){
        throw new UnsupportedOperationException();
    }

    public void receiveReward(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString(){
        throw new UnsupportedOperationException();
    }
    
    private void receiveWeapon(Weapon w){
        throw new UnsupportedOperationException();
    }
    
    
}


