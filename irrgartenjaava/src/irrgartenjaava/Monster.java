/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author jxlig0d
 */
public class Monster extends LabyrinthCharacter {
    
    // El resto de variables las eliminamos porque ya existen en super
    private static final int INITIAL_HEALTH=5;
    
    
    Monster(String name, float intelligence, float strength){
        super(name, intelligence, strength, INITIAL_HEALTH);

    }
    
    @Override
    public float attack(){
        return Dice.intensity(this.getStrength());
    }
    
    @Override
    public boolean defend(float receivedAttack){
        
        boolean isDead=this.dead();
        if(!isDead){
            float defensiveEnergy=Dice.intensity(this.getIntelligence());
            
            if (defensiveEnergy < receivedAttack){
                this.gotWounded();
                isDead=this.dead();
            }
        }
        
        return isDead;
    } 
    
    // Creo que tambien sobra porque en la clase labyrinthcharacter, ya tenemos un tostring, aunque lo dejo aqui por si acaso
    //@Override
    //public String toString(){
    //   return "M[ nombre:" + name + " , inteligencia:" + intelligence + " , fuerza: " + strength + " , salud: " + health + " , row: " + row + " , col: " + col + " ]";
    //}
    
}
