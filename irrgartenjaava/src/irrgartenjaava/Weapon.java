/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author julian
 * 
 * @brief Clase actualizada a la P4 herencia
 * 
 */
public class Weapon extends CombatElement{

  
    /**
     * Constructor clase weapon
     * 
     * @param power Poder
     * @param uses Usos
     * 
     */
    public Weapon(float power, int uses){
       super(power,uses);
        
    }
    
    // attack
    
    public float attack(){
        
        return this.produceEffect();
        
    }
    // Por que estamos modificando una funcion ya existente en su funcion padre.
    @Override 
    public String toString(){
        String a_devolver="W";
        return a_devolver+=super.toString();
        
    } 
    
}
