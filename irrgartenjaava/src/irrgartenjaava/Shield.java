/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author julian
 * 
 * 
 * @brief Clase actualizada con herencia P4
 * 
 */
public class Shield extends CombatElement {

    public Shield(float protection, int uses){
        super(protection, uses);
    }
    
    public float protect(){
        return this.produceEffect();
    }
    
    @Override 
    public String toString(){
        String a_devolver="S";
        return a_devolver+=super.toString();
        
    }
    
}
