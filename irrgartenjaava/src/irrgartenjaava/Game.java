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
    
    // rows del laberinto COMO QUIERA
    private static final int ROWS=5;
    // cols del laberinto
    private static final int COLS=4;
    
    //numero de monstruos en el laberinto e inicializacion
    
    private static final int NUM_MONSTERS=2;
    // defino AQUI LOS MONSTRUOS Y EL NUMERO COMO QUIERA
    private static final int [][] INIT_MONSTERS = {{3,1}, {0,2}};

    //NUM de obstaculos
    private static final int NUM_BLOCKS=1;
    
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
    //AQUI DEFINO LOS BLOQUES COMO QUIERA
    private static final Object [][] INIT_BLOCKS=
    { {Orientation.HORIZONTAL,2,1,3}};
    
    
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
        
        // defino la salida random
        
        //int exitRow=Dice.randomPos(ROWS);
        //int exitCol=Dice.randomPos(COLS);
        
        //definir la salida como yo quiera
        int exitRow=0;
        int exitCol=0;
        
        //inicializo el laberinto y llamamos a configure
        this.labyrinth = new Labyrinth(ROWS, COLS, exitRow, exitCol);
        this.configureLabyrinth();
        
        // lanzo los jugadores por el laberinto con spread
        // en spread podre modificarlo para ponerlos donde yo quiera
        this.labyrinth.spreadPlayers(this.players);
        
        // si llega hasta aqui, todo se cumplio asi que log:
        this.log="El juego acaba de comenzar correctamente.\n";
    
    }
    
    //comprueba si hay un ganador delegando
    public boolean finished(){
        return (this.labyrinth.haveAWinner());
    }
    
    public boolean nextStep(Directions preferredDirection){
        String log="";
        boolean dead=this.currentPlayer.dead();
        
        if(!dead){
            Directions direction= this.actualDirection(preferredDirection);
        
            if (direction !=preferredDirection){
                this.logPlayerNoOrders();
            }
            
            Monster monster=this.labyrinth.putPlayer(direction, currentPlayer);
            
            if (monster ==null){
                this.logNoMonster();
            } else {
                GameCharacter winner=this.combat(monster);
                this.manageReward(winner);
            }
        } else {
            this.manageResurrection();
        } 
        
        boolean endGame=this.finished();
        
        if (!endGame){
            this.nextPlayer();
        }
        
        return endGame;

    } 
    
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
    
        int currentRow=this.currentPlayer.getRow();
        int currentCol=this.currentPlayer.getCol();
        
        ArrayList<Directions> validMoves=this.labyrinth.validMoves(currentRow, currentCol);
    
        Directions output=this.currentPlayer.move(preferredDirection, validMoves);
        
        return output;
    }
    
    private GameCharacter combat(Monster monster){

        /*  
        //------------------------------------------------------------------------------------------------------------
        // VERSION 1.0 diagrama, siempre gana player
        
        int rounds=0;
        GameCharacter winner=GameCharacter.PLAYER;
        
        float playerAttack=this.currentPlayer.attack();
        boolean lose=monster.defend(playerAttack);
        
        while(!lose && rounds < MAX_ROUNDS){
            winner=GameCharacter.MONSTER;
            rounds++;
            float monsterAttack=monster.attack();
            lose=monster.defend(monsterAttack);
            
            if (!lose){
                playerAttack=this.currentPlayer.attack();
                winner=GameCharacter.PLAYER;
                lose=monster.defend(playerAttack);
            }
            
        }

        this.logRounds(rounds, MAX_ROUNDS);
        
        return winner;
        */
        
 
    /* 
        //-------------------------------------------------------------------------------------------------------------------
        // VERSION 2.0, casi siempre gana monster hasta morir.
        
        int rounds = 0;
        GameCharacter winner = GameCharacter.PLAYER;
    // El jugador ataca primero
    float playerAttack = this.currentPlayer.attack();
    boolean lose = monster.defend(playerAttack); // El monstruo defiende el ataque del jugador
    
    while (!lose && rounds < MAX_ROUNDS) {
        winner=GameCharacter.MONSTER;
        rounds++;
        
        // Ahora el monstruo ataca
        float monsterAttack = monster.attack();
        lose = this.currentPlayer.defend(monsterAttack); // El jugador defiende el ataque del monstruo
        
        // Si el jugador no ha perdido, vuelve a atacar
        if (!lose) {
            playerAttack = this.currentPlayer.attack();
            winner=GameCharacter.PLAYER;
            lose = monster.defend(playerAttack);
        }
        
        // Si el jugador ha perdido, el monstruo es el ganador
        if (lose) {
            winner = GameCharacter.MONSTER;
            break;
        }
    }

        // Si el jugador pierde, recibir daño del monstruo
        if (winner == GameCharacter.MONSTER) {
            float monsterDamage = monster.attack();
            this.currentPlayer.defend(monsterDamage); // El jugador recibe el daño del monstruo
        }

        this.logRounds(rounds, MAX_ROUNDS);
        return winner; 

*/
    //--------------------------------------------------------------------------------------------------------------------------
    // VERSION 3.0 aparentemente esta funciona mas o menos
    int rounds = 0;
    GameCharacter winner = GameCharacter.PLAYER;

    // El jugador ataca primero
    float playerAttack = this.currentPlayer.attack();
    boolean lose = monster.defend(playerAttack); // El monstruo defiende el ataque del jugador

    while (!lose && rounds < MAX_ROUNDS) {
        winner = GameCharacter.MONSTER;
        rounds++;

        // Ahora el monstruo ataca
        float monsterAttack = monster.attack();
        lose = this.currentPlayer.defend(monsterAttack); // El jugador defiende el ataque del monstruo

        // Si el jugador no ha perdido, vuelve a atacar
        if (!lose) {
            playerAttack = this.currentPlayer.attack();
            winner = GameCharacter.PLAYER;
            lose = monster.defend(playerAttack);
        }

        // Si el jugador ha perdido, el monstruo es el ganador
        if (lose) {
            winner = GameCharacter.MONSTER;
            break;
        }
    }

        // Si el monstruo gana, debe aplicar el daño al jugador
        if (winner == GameCharacter.MONSTER) {
            float monsterDamage = monster.attack();
            this.currentPlayer.defend(monsterDamage); // El jugador recibe el daño del monstruo
        }

        // Log de los rounds
        this.logRounds(rounds, MAX_ROUNDS);

        // Retornar al ganador
        return winner;
    } 
    
    private void manageReward(GameCharacter winner){
        
        if (winner==GameCharacter.PLAYER){
            this.currentPlayer.receiveReward();
            this.logPlayerWon();
        } else {
            this.logMonsterWon();
        }
    }
    
    private void manageResurrection(){

        boolean resurrect=Dice.resurrectPlayer();
            
        if (resurrect){
            this.currentPlayer.resurrect();
            this.logResurrected();
        } else {
            this.logPlayerSkipTurn();
        }

    }
    
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
        this.log+= "- Player "+this.currentPlayerIndex+" se ha movido a una celda vacía o no le ha sido posible moverse.\n";    
    } // debo poner porque esta vacia??

    private void logRounds(int rounds, int max){
        this.log+= "- Rounds: "+rounds+"/"+max+".\n";    
    }    

} // final de la clase
