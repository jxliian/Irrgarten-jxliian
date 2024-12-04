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
public class Player extends LabyrinthCharacter {
    
    private static final int MAX_WEAPONS=2;
    private static final int MAX_SHIELDS=3;
    private static final int INITIAL_HEALTH=10;
    private static final int HITS2LOSE=3;
    
    private char number;
    private int consecutiveHits=0;
    
    //lista de weapons y shields
    
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    // lista de barajas de shield y weapon
    private WeaponCardDeck weaponCardDeck;
    private ShieldCardDeck shieldCardDeck;
    
    
    // constructor normal
    Player(char number, float intelligence, float strength){
        
        super("Player"+number, intelligence, strength, INITIAL_HEALTH );

        this.number=number;
        this.consecutiveHits=0;
        // yo creo que asi esta bien
        // inicializar los array en blanco
        this.weapons= new ArrayList<>();
        this.shields= new ArrayList<>();
        
        // inicializamos los array
        this.weaponCardDeck= new WeaponCardDeck();
        this.shieldCardDeck= new ShieldCardDeck();
        
    }
    
    //constructor de copia.
    public Player(Player other){
        
        super(other);
        
        this.number=other.number;
        this.consecutiveHits=other.consecutiveHits;
        
        this.weapons= new ArrayList<>(other.weapons);
        this.shields= new ArrayList<>(other.shields);
        
        this.weaponCardDeck=other.weaponCardDeck;
        this.shieldCardDeck= other.shieldCardDeck;

    }
    
    public void resurrect(){
        
        // Vaciar las listas 
        this.weapons.clear();
        this.shields.clear();
        
        this.setHealth(INITIAL_HEALTH);
        this.resetHits();
    }
    
    public char getNumber(){
        return number;
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
    
    // actualizado de p4
    @Override
    public float attack(){
        return (this.getStrength()+this.sumWeapons());
    }
    
    @Override
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
        
        this.setHealth(this.getHealth()+Dice.healthReward());        
    }
    
    // Modificado para la p4, veremos como funciona
    @Override
    public String toString(){
        //return "P[ nombre:" + name + " , golpes_consecutivos:" + consecutiveHits + " ,  fila:" + row + " , columna:" + col + " , salud: " + health + " , numero:" +number + ", fuerza:"+ strength + ", inteligencia:"+ intelligence +"]";
        
        String toReturn=super.toString();
        toReturn+=" [ ch:"+this.consecutiveHits+", ";
        
        // Bucles para mostrar con un formato determinado el array de
        // armas y escudos del jugador
        String toWeapons="[";
        int tamWeapons=this.weapons.size();
        for(int i=0; i<tamWeapons-1; i++){
            toWeapons+=this.weapons.get(i).toString()+", ";
        }
        if (tamWeapons>0)
            toWeapons+=this.weapons.get(tamWeapons-1);
        toWeapons+="]";
        
        String toShields="[";
        int tamShields=this.shields.size();
        for(int i=0; i<tamShields-1; i++){
            toShields+=this.shields.get(i).toString()+", ";
        }
        if (tamShields>0)
            toShields+=this.shields.get(tamShields-1);
        toShields+="]";
        
        // Definimos el formato final para el toString
        toReturn+="w:" + toWeapons+", sh:"+toShields+" ]";
        
        return toReturn;
    
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
    
    // cambiado de la p4
    private Weapon newWeapon(){   
        return this.weaponCardDeck.nextCard();
    }
    
    //cambiado de la p4
    private Shield newShield(){
        return this.shieldCardDeck.nextCard();
        //Shield escudito = new Shield(Dice.shieldPower(), Dice.usesLeft());
        //return escudito;
    }
    
    protected float sumWeapons(){
        float sum=0;
        for (int i=0; i < weapons.size(); i++){
            sum+= weapons.get(i).attack();
        }
        return sum;      }
    
    protected float sumShields(){ // el panas
        float sum=0;
        for (int i=0; i < shields.size(); i++){
            sum+= shields.get(i).protect();
        }
        return sum;   
    }
    
    protected float defensiveEnergy(){
        return (this.getIntelligence() + this.sumShields());     
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
    
    private void incConsecutiveHits(){
        this.consecutiveHits++;
    }
    
}


