/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

import java.util.Random; // random lib

/**
 *
 * @author julian
 */
public class Dice {
        // cumplimos los requisitos de que las variables sean private static final (final = const en c++)
   
    private static final int MAX_USES = 5;// (número máximo de usos de armas y escudos)
    private static final double MAX_INTELLIGENCE = 10.0; // (valor máximo para la inteligencia de jugadores y monstruos)
    private static final double MAX_STRENGTH = 10.0; // (valor máximo para la fuerza de jugadores y monstruos)
    private static final double RESURRECT_PROB = 0.3; // (probabilidad de que un jugador sea resucitado en cada turno)
    private static final int WEAPONS_REWARD = 2; // (numero máximo de armas recibidas al ganar un combate)
    private static final int SHIELDS_REWARD = 3; //(numero máximo de escudos recibidos al ganar un combate)
    private static final int HEALTH_REWARD = 5; // (numero máximo de unidades de salud recibidas al ganar un combate)
    private static final int MAX_ATTACK = 3; //(máxima potencia de las armas)
    private static final int MAX_SHIELD = 2; // (máxima potencia de los escudos)
    private static final Random generator = new Random(); 
    
    public static int randomPos(int max){
        return generator.nextInt(max);
        
    }
    
    public static int whoStarts(int nplayers){
        return generator.nextInt(nplayers);
        
    }
    
    public static float randomIntelligence(){
        return generator.nextFloat()*(float)MAX_INTELLIGENCE;
        
    }
    
    public static float randomStrength(){
        return generator.nextFloat()*(float)MAX_STRENGTH;
    }
    
    public static boolean resurrectPlayer(){
        return generator.nextFloat()< RESURRECT_PROB;
  
    }
    
    public static int weaponsReward(){
        return generator.nextInt(0, WEAPONS_REWARD);
    }
    
    public static int shieldsReward(){
        return generator.nextInt(0, SHIELDS_REWARD);    
    }
    
    public static int healthReward(){
        return generator.nextInt(0, HEALTH_REWARD);
        
    }
    
    public static float weaponPower(){
        return generator.nextInt(0,MAX_ATTACK);
  
    }
    
    public static float shieldPower(){
        return generator.nextInt(0,MAX_SHIELD);
        
    }
    
    public static int usesLeft(){
        return generator.nextInt(0, MAX_USES);
        
    }
    
    public static float intensity(float competence){
        return generator.nextFloat()*competence;
        
    }
    
    /*
    
    este método devuelve true con una probabilidad
    inversamente proporcional a lo cercano que esté el parámetro del número máximo de usos que
    puede tener un arma o escudo. Como casos extremos, si el número de usos es el máximo devolverá
    false y si es 0 devolverá true. Es decir, las armas o escudos con más usos posibles es menos
    probable que sean descartados.
    
    */
    
    public static boolean discardElement(int usesLeft){
        float probabilidad_inversa=(1-((float)usesLeft/MAX_USES));
        
        if (usesLeft >= MAX_USES){
            return false; 
        }
        
        if (usesLeft <= 0){
            return true;
        }
        
        return generator.nextFloat() < probabilidad_inversa; 
        
    }
}


