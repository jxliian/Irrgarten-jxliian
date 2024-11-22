/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

/**
 *
 * @author jxlig0d
 * 
 * @brief P4, clase abstracta de las entidades del laberinto
 * 
 */
abstract class LabyrinthCharacter {
    
    // Variable que guarda el name
    private String name;
    
    // Variable que guarda la inteligencia
    private float intelligence;
    
    // Variable que guarda la fuerza
    private float strength;
    
    // Variable que guarda la vida
    private float health;
    
    // Variable que guarda el row
    private int row;
    
    // Variable que guarda el col
    private int col;
    
    private static final int INVALIDA=-1;
    
    
    // constructor por defecto.
    public LabyrinthCharacter(String name, float intelligence, float strength, float health){
        
        this.name=name;
        this.intelligence=intelligence;
        this.strength=strength;
        this.health=health;
        
        this.row=INVALIDA;
        this.col=INVALIDA;
    }
    
    //constructor de copia.
    public LabyrinthCharacter(LabyrinthCharacter other){
        
        this.name=other.name;
        this.intelligence=other.intelligence;
        this.strength=other.strength;
        this.health=other.health;
        
        this.row=other.row;
        this.col=other.col;
    }
    
    
    //----------------------------------------------------------------------------------------------------
    // getters y setters
    
    protected float getIntelligence(){
        return this.intelligence;
    }
    
    protected float getStrength(){
        return this.strength;
    }
    
    protected float getHealth(){
        return this.health;
    }
    
    protected void setHealth(float health){
        this.health=health;
    }
    
    
    
    
    
}
