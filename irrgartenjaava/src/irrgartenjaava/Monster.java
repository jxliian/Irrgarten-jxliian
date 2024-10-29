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
        this.health=INITIAL_HEALTH; // esta no se si es necesaria
        
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
        throw new UnsupportedOperationException();
    } // P3 lo hare cuando llegue a P3
    
    public void setPos(int row, int col){
        this.row=row;
        this.col=col;
    }
    
    @Override
    public String toString(){
        return "M[" + name + " , "  + intelligence + " , " + strength + " , " + health + "]";
        // no se que falta, a lo mejor falta row o col
    }
    
    private void gotWounded(){
        this.health=this.health-1;
    }   // mal escrito?
    
}
