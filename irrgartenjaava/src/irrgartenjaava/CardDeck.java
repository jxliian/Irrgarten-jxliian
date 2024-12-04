/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgartenjaava;

import java.util.Collections; //para barajar
import java.util.ArrayList; // array de cartas

/**
 *
 * Clase parametrizable y abstracta de la baraja de cartas del juego.
 * 
 * @author jxlig0d
 * 
 * 
 * Le puedo meter la T de extends Combat element por:
 * 
 * Control de tipos
 * 
 * Polimorfismo
 * 
 * Acceso a propiedades y métodos comunes:
 * 
 * PD: ya he actualizado lo de los constructores de player
 * y lo de newweapon/shield 
 * 
 */
abstract class CardDeck <T extends CombatElement> {
    
    private ArrayList<T> cardDeck;
    
    protected static final int TAM_MAX=99;
    
    public CardDeck(){
        this.cardDeck=new ArrayList();
    }
    
    protected abstract void addCards();
    
    protected void addCard(T card){
        this.cardDeck.add(card);
    }
    
    public T nextCard(){
        
      if(this.cardDeck.size()<=0) { // si no hay cartas
            this.addCards(); // añadimos con addcards
            Collections.shuffle(this.cardDeck); // barajamos
        }
       //independientemente se selecciona la primera carta y se elimina
        T sel=this.cardDeck.get(0);
        this.cardDeck.remove(0);
        //y devolvemos la seleccionada
        return sel;  
        
    }
}
