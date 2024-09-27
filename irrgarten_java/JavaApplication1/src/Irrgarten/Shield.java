/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Irrgarten;

/**
 *
 * @author julian
 */
public class Shield {

    // Private attributes
    private float protection;
    private int uses;
    
    public Shield(float protection, int uses){
        this.protection=protection;
        this.uses=uses;
        
    }
    
    public float protect(){
        if (uses<0){
            uses--;
            return protection;
        } else {
            return 0;
        }
    }
    
    @Override 
    public String toString(){
        return "S[" + protection + " , " + uses + "]";
        // Y con esto ya lo pasa solo a string
        
    }
    
    
    
    
    
}
