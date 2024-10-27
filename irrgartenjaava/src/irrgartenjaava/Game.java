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
public class Game {
    
    // ....................................... LABYRYNTH STUFF ..........................................
    
    // rows del laberinto
    private static final int ROWS=7;
    // cols del laberinto
    private static final int COLS=7;
    
    //numero de monstruos en el laberinto e inicializacion
    
    private static final int NUM_MONSTERS=3;
    // al azar vaya
    private static final int [][] INIT_MONSTERS = {{0,0}, {1,1}, {2,2}, {3,3}, {1,3}};

    //NUM de obstaculos
    private static final int NUM_BLOCKS=4;
    
    //................................. REST PERSONALIZATION .....................................
    
    //player id
    private int currentPlayerIndex;
    
    private Player currentPlayer;
    
    // max num de rondas
    private static final int MAX_ROUNDS=10;
    
    // log
    private String log;
    
    // array de jugadores
    private ArrayList<Player> players;
    
    // array de monsters
    private ArrayList<Monster> monsters;
    
    // laberinto 
    private Labyrinth labyrinth;
    
    /*
    fumadon historico, para settear los muros, con el tipo object,
    una especie de auto de c++ para castear a lo que sea necesario despues
    */ 
    private static final Object [][] INIT_BLOCKS=
    { {Orientation.HORIZONTAL,0,0,3}, {Orientation.HORIZONTAL,3,3,5}, 
      {Orientation.VERTICAL,  5,6,2}, {Orientation.VERTICAL,  6,5,3} };
    
    
    /*
    En el constructor hay que crear los jugadores y añadirlos al 
    contenedor adecuado, determinar quien va a empezar y fijar el 
    jugador con el turno. Inicializa también el atributo contenedor 
    de monstruos e instancia un laberinto para inicializar el 
    atributo labyrinth. Inicializa el resto de atributos con los
    valores iniciales que consideres apropiados. 
    Para finalizar, se debe llamar al método que configura
    el laberinto y al que reparte los jugadores por el mismo.
    */
    Game(int nplayers){
        
        //inicializamos arrays de jugadores y monsters
        
        this.players= new ArrayList<>();
        this.monsters= new ArrayList<>();

        // creamos los jugadores y los metemos en el vector
        for(int i=0; i<nplayers; i++){
             // character.fordigit para que los caracteres especificos
             // represente numeros y no los valores enteros mismos
            this.players.add(new Player(Character.forDigit(i, 10), 
            Dice.randomIntelligence(), Dice.randomStrength()));
        }
        
        // hacemos que current player sea el que empiece el juego
        this.currentPlayerIndex=Dice.whoStarts(nplayers);
        this.currentPlayer=this.players.get(this.currentPlayerIndex);
        
        // defino la salida
        
        int exitRow=Dice.randomPos(ROWS);
        int exitCol=Dice.randomPos(COLS);
        
        //inicializo el laberinto y llamamos a configure
        this.labyrinth = new Labyrinth(ROWS, COLS, exitRow, exitCol);
        this.configureLabyrinth();
        
        // lanzo los jugadores por el laberinto con spread
        this.labyrinth.spreadPlayers(this.players);
        
        // si llega hasta aqui, todo se cumplio asi que log:
        this.log="El juego acaba de comenzar correctamente.\n";
    
    }
    
    //comprueba si hay un ganador delegando
    public boolean finished(){
        return (this.labyrinth.haveAWinner());
    }
    
    public boolean nextStep(Directions preferredDirection){
        throw new UnsupportedOperationException();
    } //P3
    
    public GameState getGameState(){
        
        String infoplayers="";
        String infomonsters="";
        
        //info players
        for (int i=0; i<this.players.size(); i++){
            infoplayers+="-> " + this.players.get(i).toString()+"\n";
        }
        
        // info monsters
        for (int i=0; i<this.monsters.size(); i++){
            infomonsters+="->" + this.monsters.get(i).toString()+"\n";
        }
        
        // gamestate con todos los indices
        GameState gamestate = new GameState (this.labyrinth.toString(), infoplayers,
                   infomonsters, this.currentPlayerIndex, this.finished(), this.log);
        
        return gamestate;       
    }
    
    // clase fumadon, hasta los monstruos bien, he puesto las pos en las 
    // variables locales random, luego las cambiare
    private void configureLabyrinth(){
        // Inicializamos el vector de monstruos y los añadimos al laberinto
        for (int i=0; i<NUM_MONSTERS; i++){
            Monster monstruo=new Monster ("Monster "+i, Dice.randomIntelligence(), Dice.randomStrength());
            this.monsters.add(monstruo);
            // Destacar que la primera variable indica fila y la segunda columna
            this.labyrinth.addMonster(INIT_MONSTERS[i][0], INIT_MONSTERS[i][1], monstruo);
        }
        
        // Añadimos los bloques al laberinto
        for (int i=0; i<NUM_BLOCKS; i++){
            this.labyrinth.addBlock((Orientation)INIT_BLOCKS[i][0], (int)INIT_BLOCKS[i][1], 
                    (int)INIT_BLOCKS[i][2], (int)INIT_BLOCKS[i][3]);
        }    
    
    }
    
    // pasar al siguiente players
    private void nextPlayer(){
        // % para no poner un siguiente indice que este fuera
        this.currentPlayerIndex=(this.currentPlayerIndex+1)%this.players.size();
        this.currentPlayer=this.players.get(this.currentPlayerIndex);
        // y actualizamos el current player con el id actualizado

    }
    
    private Directions actualDirection(Directions preferredDirection){
        throw new UnsupportedOperationException();
    }//P3
    
    private GameCharacter combat(Monster monster){
        throw new UnsupportedOperationException();
    }//P3 
    
    private void manageReward(GameCharacter winner){
        throw new UnsupportedOperationException();
    }//P3
    
    private void manageResurrection(){
        throw new UnsupportedOperationException();
    }//P3
    
    private void logPlayerWon(){
        this.log+= "- Player "+this.currentPlayerIndex+" gano la pelea.\n";    
    }
    
    private void logMonsterWon(){
        this.log+= "- Monster gano la pelea.\n";    
    }        

    private void logResurrected(){
        this.log+= "- Player "+this.currentPlayerIndex+" fue revivido.\n";    
    }    
    
    private void logPlayerSkipTurn(){
        this.log+= "- Player "+this.currentPlayerIndex+" ha perdido el turno por estar muerto.\n";    
    }    
    
    private void logPlayerNoOrders(){
        this.log+= "- Player "+this.currentPlayerIndex+" no fue posible seguir las ordenes del jug. humano.\n";    
    }

    private void logNoMonster(){
        this.log+= "- Player "+this.currentPlayerIndex+" no es posible moverse a esta casilla.\n";    
    } // debo poner porque esta vacia??

    private void logRounds(int rounds, int max){
        this.log+= "- Rounds: "+rounds+"/"+max+".\n";    
    }    

} // final de la clase
