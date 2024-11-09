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
    private static final int INVALID_POS=-1;
    private int nRows, nCols, exitRow, exitCol;
    
    //matriz estatica de los monstruos en el labyrinth
    private Monster [][] monsters;
    //matriz estatica de los players en el labyrinth
    private Player [][] players;
    // matriz que representa el labyrinth y los estados de sus casillas
    private char [][] labyrinth;
    
    Labyrinth(int nRows, int nCols, int exitRow, int exitCol){
        // inicializamos valores
        this.nRows=nRows;
        this.nCols=nCols;
        this.exitRow=exitRow;
        this.exitCol=exitCol;
        
        // definimos las 3 matrices
        this.players= new Player[nRows][nCols];
        this.monsters= new Monster[nRows][nCols];
        this.labyrinth= new char[nRows][nCols];
        
        //construimos un laberinto por defecto vacio
        
        for (int i=0; i<this.nRows; i++){
            for(int j=0; j<this.nCols; j++){
                this.labyrinth[i][j]=EMPTY_CHAR;
            }
        }
        
        // definimos nuestra salida del laberinto
        this.labyrinth[exitRow][exitCol]=EXIT_CHAR;
    }
    
    
    public void spreadPlayers(ArrayList<Player> players){
        
        Player p;
        for (int i=0; i< players.size();i++){
            p=players.get(i);
            int [] pos = randomEmptyPos();
            this.putPlayer2D(INVALID_POS, INVALID_POS, pos[ROW], pos[COL], p);
        }
    }
    
    public boolean haveAWinner(){
        boolean ganador=false;
        // creo que asi si estaria bien
        if(this.labyrinth[this.exitRow][this.exitCol]==EXIT_CHAR){
            ganador=true;
        } else {
            ganador=false;
        }

        return ganador;
    }
    
    @Override
    public String toString(){
        
        StringBuilder laberinto = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
            laberinto.append("[").append(labyrinth[i][j]).append("]");
            }
            laberinto.append("\n");
        }
        return laberinto.toString();
     
    } // este no se si esta bien la verdad
    
    public void addMonster(int row, int col, Monster monster){
        // si esta dentro del laby...
        if (posOK(row, col) && emptyPos(row, col)){
            //ponemos monstruo en esa pos
            monster.setPos(row,col);
            // seteamos esa info en su pos de monsters
            this.monsters[row][col]=monster;
            // seteamos esa info en su pos del laby
            this.labyrinth[row][col]=MONSTER_CHAR;
        }
    }
    
    //P3
    public Monster putPlayer(Directions direction, Player player){
        throw new UnsupportedOperationException();
    }
    
    //p3
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        throw new UnsupportedOperationException();
    }
   
    
    public ArrayList<Directions> validMoves(int row, int col){
    
        ArrayList<Directions> output = new ArrayList<>();

        if (canStepOn(row+1, col))
            output.add(Directions.DOWN);
        if (canStepOn(row-1, col))
            output.add(Directions.UP);
        if (canStepOn(row, col+1))
            output.add(Directions.RIGHT);
        if (canStepOn(row, col-1))
            output.add(Directions.LEFT);

        return output;
    }
    
    // devuelve true si esta dentro, false si no
    private boolean posOK(int row, int col){
        return (row >=0 && col>=0 && row<this.nRows && col<this.nCols);
    }
    
    // devuelve true si es un empty char, si no false
    private boolean emptyPos(int row, int col){
        return (this.labyrinth[row][col]==EMPTY_CHAR);
    } 
    
    // true si es posicion de un monstruo, false si no
    private boolean monsterPos(int row, int col){
        return (this.labyrinth[row][col]==MONSTER_CHAR);
    }

    // true si es posicion de SALIDA, false si no    
    private boolean exitPos(int row, int col){
        return (this.labyrinth[row][col]==EXIT_CHAR);
    }

    // true si es posicion de combate, false si no        
    private boolean combatPos(int row, int col){
        return (this.labyrinth[row][col]==COMBAT_CHAR);
    }
    
    // puede pasar o no
    private boolean canStepOn(int row, int col){
        boolean estadentro;
        estadentro = this.posOK(row, col);
        // si esta dentro y contiene alguna de esas 3 posibilidades 
        estadentro= estadentro && (this.monsterPos(row, col) 
        || this.emptyPos(row, col) || this.exitPos(row, col));
        
    return estadentro;
    }
    
    //  actualizar pos segun situacion
    private void updateOldPos(int row, int col){
        //si esta dentro del laberinto...
        if (this.posOK(row, col)){
            //si es posicion de compate, actualizar que hay monster
            if(this.combatPos(row, col)){
                this.labyrinth[row][col]=MONSTER_CHAR;
            } else { // en caso contrario, estara vacia 
                this.labyrinth[row][col]=EMPTY_CHAR;
            }
        }
    
    /*Este método es llamado cuando un jugador abandona una 
    casilla y se encarga de dejar la casilla que se 
    abandona en el estado correcto.*/    
    
    }
    
    // Nueva pos tras el movimiento
    private int[] dir2Pos(int row, int col, Directions direction){
        //devolveremos  un array estatico con la nueva pos
        int[] nuevapos = new int [2]; 
        //metemos nuestra pos en la nueva pos para poder decidir
        nuevapos[ROW]=row;
        nuevapos[COL]=col;
        
        // segun el caso, aumentamos o disminuimos col o row
        // left=col--, right=col++, up=row--; down=row++
    
        switch(direction){
            case RIGHT:
                nuevapos[COL]++;
                break;                
            case UP:
                nuevapos[ROW]--;
                break;                
            case DOWN:
                nuevapos[ROW]++;
                break;
            case LEFT:
                nuevapos[COL]--;
                break;
        }   
        return nuevapos;
    }
    
    
    //array estatico
    private int[] randomEmptyPos(){
        int row, col;
        //bucle infinito???
        do{
            row=Dice.randomPos(this.nRows);
            col=Dice.randomPos(this.nCols);      
        } while (!this.emptyPos(row,col));
        
        // si no ha sido bucle infinito, devolvemos esa pos
        int[] pos_a_devolver= new int [2];
        pos_a_devolver[ROW]=row;
        pos_a_devolver[COL]=col;        

        return pos_a_devolver;
    }
    
    //P3
    private Monster putPlayer2D(int oldRow, int oldCol, int row, int col, Player player){
        throw new UnsupportedOperationException();    
    }
    
    
} // fin clase


