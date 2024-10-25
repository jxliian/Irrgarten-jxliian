/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

import java.util.ArrayList;

/**
 *
 * @author jxlig0d
 */
public class Labyrinth {
    
    private static final char BLOCK_CHAR= 'X';
    private static final char EMPTY_CHAR='-';
    private static final char MONSTER_CHAR='M';
    private static final char COMBAT_CHAR='C';
    private static final char EXIT_CHAR='E';
    private static final int ROW=0;
    private static final int COL=1;
    private int nRows, nCols, exitRow, exitCol;
    
    Labyrinth(int nRows, int nCols, int exitRow, int exitCol){
        throw new UnsupportedOperationException();
    }
    
    // me quedao por aqui
    public void spreadPlayers(ArrayList<Player> players){
        throw new UnsupportedOperationException();
    }
    
    public boolean haveAWinner(){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString(){
        throw new UnsupportedOperationException();
    }
    
    public void addMonster(int row, int col, Monster monster){
        throw new UnsupportedOperationException();
    }
    
    public Monster putPlayer(Directions direction, Player player){
        throw new UnsupportedOperationException();
    }
    
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        throw new UnsupportedOperationException();
    }
    
    public ArrayList<Directions> validMoves(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    private boolean posOK(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    private boolean emptyPos(int row, int col){
        throw new UnsupportedOperationException();
    } 
    
    private boolean monsterPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    private boolean exitPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    private boolean combatPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    private boolean canStepOn(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    private void updateOldPos(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    private int[] dir2Pos(int row, int col, Directions direction){
        throw new UnsupportedOperationException();  
    }
    
    private int[] randomEmptyPos(){
        throw new UnsupportedOperationException();
    }
    
    private Monster putPlayer2D(int oldRow, int oldCol, int row, int col, Player player){
        throw new UnsupportedOperationException();    
    }
}


