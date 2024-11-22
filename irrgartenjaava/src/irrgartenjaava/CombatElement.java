/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author jxlig0d
 * 
 * @brief P4, le he puesto el abstract
 * 
 */
abstract class CombatElement {
    
    //effect, ya sea para protect, o para attack, el que sea
    private float effect;
    
    //uses
    private int uses;
    
    //constructor
    public CombatElement(float eff, int uses){
        this.effect=eff;
        this.uses=uses;
    }
        
    // tal cual copiado de weapon, cambiando effect
    protected float produceEffect(){
        
         if (uses >0){
            uses--;
            return effect;
            
        } else {
            
            return 0;
        }
    }
    
    
    public boolean discard(){
        return Dice.discardElement(this.uses);
        
    }
    
    @Override
    public String toString(){
        return " : C_E[" + effect + " , " + uses + "]";

    }
    
}
