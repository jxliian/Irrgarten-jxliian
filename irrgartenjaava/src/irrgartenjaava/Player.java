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
    private char number=0;
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
        this.number=number;
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
    
    //creo que esta bien
    public Directions move(Directions direction, ArrayList<Directions>validMoves){
      
      int size=validMoves.size();
      boolean contained=validMoves.contains(direction);
      
      Directions aux;
      
      if ((size > 0) && !contained){
          
          aux=validMoves.get(0);
      } else {
          aux=direction;
      }
      
      return aux;
        
    } // directions [] me refiero
    
    public float attack(){
        return (this.strength+this.sumWeapons());
    }
    
    public boolean defend(float receivedAttack){
        return this.manageHit(receivedAttack);
    }
    
    public void receiveReward(){ 

        int wReward= Dice.weaponsReward();
        int sReward= Dice.shieldsReward();
        Weapon wnew;
        
        for (int i=0; i<wReward ; i++){
            this.receiveWeapon(this.newWeapon());    
        }
        
        for (int j=0; j<sReward; j++){
            this.receiveShield(this.newShield());
        }
        
        int extraHealth;
        
        extraHealth=Dice.healthReward();
        this.health+=extraHealth;
        
    }
    
    @Override
    public String toString(){
        return "P[ nombre:" + name + " , golpes_consecutivos:" + consecutiveHits + " ,  fila:" + row + " , columna:" + col + " , salud: " + health + " , numero:" +number + ", fuerza:"+ strength + ", inteligencia:"+ intelligence +"]";
    }
    
    private void receiveWeapon(Weapon w){ // P3
        
        Weapon wi;
        Dice dados= new Dice();
        for(int i=0; i<weapons.size(); i++){
            wi=weapons.get(i);
            // por la p4, en discard quite el dados, recuerdalo
            //por si da fallos
            boolean discard= wi.discard();
            
            if(discard){
                weapons.remove(wi);
            }
            
            int size=weapons.size();
            
            if (size < MAX_SHIELDS){
                weapons.add(w);
            }
        }
    }
    
    private void receiveShield(Shield s){

        Shield si;
        Dice dados= new Dice();
        for(int i=0; i<shields.size(); i++){
            si=shields.get(i);
            // lo mismo de la p4
            boolean discard= si.discard();
            
            if(discard){
                shields.remove(si);
            }
            
            int size=shields.size();
            
            if (size < MAX_SHIELDS){
                shields.add(s);
            }
        }
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
        
        float defense=this.defensiveEnergy();
        
        if (defense < receivedAttack){
            this.gotWounded();
            this.incConsecutiveHits();
            
        } else {
            this.resetHits();
        }
        
        boolean lose=((this.consecutiveHits == HITS2LOSE) || (this.dead()));
        
        // lose, si no return
        if (lose){
            this.resetHits();
        }
        
        return lose;
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


