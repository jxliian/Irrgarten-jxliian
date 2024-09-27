/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Irrgarten;

/**
 *
 * @author julian
 */
public class Weapon {
    
// Private attributes
    private float power;
    private int uses;
    
    
  
    /**
     * Constructor clase weapon
     * 
     * @param power Poder
     * @param uses Usos
     * 
     */
    public Weapon(float power, int uses){
        this.power = power;
        this.uses=uses;
        
    }
    
// attack
    
    public float attack(){
        
        if (uses >0){
            uses--;
            return power; // esta bien hacer esto??
            
        } else {
            
            return 0;
        }
        
    }
    // Por que estamos modificando una funcion ya existente en su funcion padre.
    @Override 
    public String toString(){
        return "W[" + power + " , " + uses + "]";
        // Y con esto ya lo pasa solo a string
        
    }
    
    
    
}
