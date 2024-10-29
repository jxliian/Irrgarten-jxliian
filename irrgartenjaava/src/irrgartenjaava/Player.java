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
    
    //lista de weapons y shields
    
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    
    Player(char number, float intelligence, float strength){
        
        this.name="Player #"+number;
        this.intelligence=intelligence;
        this.strength=strength;
        this.health=INITIAL_HEALTH;
        this.consecutiveHits=0;
        // yo creo que asi esta bien
        // inicializar los array en blanco
        this.weapons= new ArrayList<>();
        this.shields= new ArrayList<>();
        
    }
    
    public void resurrect(){
        
        // Vaciar las listas 
        this.weapons.clear();
        this.shields.clear();
        
        this.health= INITIAL_HEALTH;
        this.consecutiveHits=0;
    }
    
    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
    
    public char getNumber(){
        return number;
    }

    public void setPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    public boolean dead(){
        return health<=0;       //true si health=0 si muerto
    }
    
    public Directions move(Directions direction, ArrayList<Directions>validMoves){
        throw new UnsupportedOperationException(); // se hace asi???
    } //continuara P3                             // directions [] me refiero
    
    public float attack(){
        return (this.strength+this.sumWeapons());
    }
    
    public boolean defend(float receivedAttack){
        return this.manageHit(receivedAttack);
    }
    
    public void receiveReward(){ // P3
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString(){
        return "P[" + name + " , " + consecutiveHits + " , " + row + " , " + col + " , " + health + " , " +number + ", "+ strength + ", "+ intelligence +"]";
    }
    
    private void receiveWeapon(Weapon w){ // P3
        throw new UnsupportedOperationException();
    }
    
    private void receiveShield(Shield s){ // P3
        throw new UnsupportedOperationException();
    }
    
    private Weapon newWeapon(){   
        Weapon espadita = new Weapon(Dice.weaponPower(), Dice.usesLeft());
        return espadita;
    }
    
    private Shield newShield(){
        Shield escudito = new Shield(Dice.shieldPower(), Dice.usesLeft());
        return escudito;
    }
    
    private float sumWeapons(){
        float sum=0;
        for (int i=0; i < weapons.size(); i++){
            sum+= weapons.get(i).attack();
        }
        return sum;      }
    
    private float sumShields(){ // el panas
        float sum=0;
        for (int i=0; i < shields.size(); i++){
            sum+= shields.get(i).protect();
        }
        return sum;   
    }
    
    private float defensiveEnergy(){
        return (this.intelligence + this.sumShields());     
    }
   
    private boolean manageHit(float receivedAttack){
        throw new UnsupportedOperationException();        
            // P3
    }
    
    private void resetHits(){
        this.consecutiveHits=0;
    }
   
    private void gotWounded(){
        this.health-=1;
    }
    
    private void incConsecutiveHits(){
        this.consecutiveHits++;
    }
    
}


