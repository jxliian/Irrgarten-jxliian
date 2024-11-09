/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author jxlig0d
 */
public class Monster {
    
    private static final int INITIAL_HEALTH=5;
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    
    
    Monster(String name, float intelligence, float strength){
        this.intelligence=intelligence;
        this.name=name;
        this.strength=strength;
        this.health=INITIAL_HEALTH;
        this.row=0;
        this.col=0;

        // esta no se si es necesaria
        
        // me falta lo de definir si no esta en ninguna casilla
        // del laberinto?? x=y=-1?

    }
    
    public boolean dead(){
        return health<=0;
    }
    
    //auxiliar getter for private variable
    public float getStrength(){
        return strength;
    }
    
    public float attack(){
        return Dice.intensity(this.getStrength());
    }
    
    public boolean defend(float receivedAttack){
        
        boolean isDead=this.dead();
        if(!isDead){
            float defensiveEnergy=Dice.intensity(this.intelligence);
            
            if (defensiveEnergy < receivedAttack){
                this.gotWounded();
                isDead=this.dead();
            }
        }
        
        return isDead;
    } 
    
    public void setPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    @Override
    public String toString(){
       return "M[ nombre:" + name + " , inteligencia:" + intelligence + " , fuerza: " + strength + " , salud: " + health + " , row: " + row + " , col: " + col + " ]";
    }
    
    private void gotWounded(){
        this.health=this.health-1;
    }   // mal escrito?
    
}
