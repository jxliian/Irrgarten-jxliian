#encoding:utf-8

require_relative 'dice'
require_relative 'weapon'
require_relative 'shield'

module Irrgarten

  class Player 

    #maximo numero de armas que puede tener un jugador
    @@MAX_WEAPONS=2; 
    #maximo numero de escudos que puede tener un jugador
    @@MAX_SHIELDS=3;
    #maximo numero de unidades de salud que puede tener un jugador
    @@INITIAL_HEALTH=10;
    #numero de golpes que puede recibir un jugador antes de perder
    @@HITS2LOSE=3;

    #constructor
    def initialize(number, intelligence, strength)
    
      @name="Player #"+number.to_s
      @intelligence=intelligence
      @strength=strength
      @health=@@INITIAL_HEALTH
      @col=0
      @row=0
      # supongo que asi esta bien hecho el health

      #creamos los array de weapons y shields

      @weapons=Array.new
      @shields=Array.new

      @consecutive_hits=0
    end

    #consultores para los atributos
    #no se si todos son necesarios

    protected
    # asi pueden acceder en la misma clase
    # pero no fuera de ella
    attr_reader :weapons
    attr_reader :shields
    attr_reader :health
    attr_reader :intelligence
    attr_reader :strength
    attr_reader :consecutive_hits
    attr_reader :row
    attr_reader :col
    attr_reader :number


    public

    def  resurrect()

      weapons.clear
      shields.clear

      @health=@@INITIAL_HEALTH
      @consecutive_hits=0

    end 

    def set_pos(row, col)

      @row=row
      @col=col

    end

    def get_pos()
      return @row, @col
    end

    def dead()
        
      @health<=0
  
    end

    #def move(direction, valid_moves)
    #p3

    def attack()
      return @strength+sum_weapons()
    end

    def defend(received_attack)
      return manage_hit(received_attack)
    end

    #def receive_reward()
    #p3

    def to_s()
      return "P [#{@name} #{@consecutive_hits} #{@row} #{@col} #{@health} #{@number} #{@strength} #{@intelligence} ]"
    end

    #def receive_weapon(w)
    #p3

    #def receive_shield(s)
    #p3

    def new_weapon()
      espadita=Weapon.new(Dice.weapon_power(),Dice.uses_left())
      return espadita
    end

    def new_shield()
      escudito=Shield.new(Dice.shield_power(),Dice.uses_left())
      return escudito
    end

    #espero que este bien hecho, la vd nls
    def sum_weapons()
      sum=0
      for i in 0..@weapons.size-1
        sum+=@weapons[i].attack()
      end
      return sum
    end

    #espero que este bien hecho, la vd nls
    def sum_shields()
      sum=0
      for i in 0..@shields.size-1
        sum+=@shields[i].protect()
      end
      return sum
    end

    def defensive_energy()
      return @intelligence+sum_shields()
    end

    #def manage_hit(received_attack)
    #p3

    def reset_hits()
      @consecutive_hits=0
    end

    def got_wounded()
      @health-=1
    end

    def inc_consecutive_hits()
      @consecutive_hits+=1
    end

  end #end class

end #end module