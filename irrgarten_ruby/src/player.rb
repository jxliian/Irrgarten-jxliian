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

        # Consultor de @number
        # @return [char] número del jugador
        attr_reader :number
        attr_reader :col
        attr_reader :row


    protected
        # Consultor de @weapons
        # @return [Array<Weapon>] array de armas del jugador
        attr_reader :weapons

        # Consultor de @shields
        # @return [Array<Shield>] array de escudos del jugador
        attr_reader :shields

        # Consultor de @consecutive_hits
        # @return [int] número de golpes consecutivos recibidos
        attr_reader :consecutive_hits


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

    #p3
    def move(direction, valid_moves)

      size=valid_moves.size
      contained=valid_moves.include?(direction)

      if size > 0 && !contained
        aux=valid_moves[0]
      else 
        aux=direction
      end

      return aux


    end
    
    
    def attack()
      return @strength+sum_weapons()
    end

    def defend(received_attack)
      return manage_hit(received_attack)
    end
    
    #p3
    def receive_reward()
      
      wReward=Dice.weapon_reward()
      sReward=Dice.shield_reward()

      wReward.times do |i|
        receive_weapon(self.new_weapon)
      end

      sReward.times do |i|
        receive_shield(self.new_shield)
      end

      @health+=Dice.health_reward()

    end

    def to_s()
      return "P [#{@name} #{@consecutive_hits} #{@row} #{@col} #{@health} #{@number} #{@strength} #{@intelligence} ]"
    end
    
    #p3
    def receive_weapon(w)
      
      @weapons.delete_if do |wi|
        wi.discard
      end

      if (@weapons.length < @@MAX_WEAPONS)
        @weapons.push(w)
      end

    end

    #p3
    def receive_shield(s)
    
      @shields.delete_if do |si|
        si.discard
      end

      if (@shields.length < @@MAX_SHIELDS)
        @shields.push(s)
      end
    end

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

    #p3
    def manage_hit(received_attack)
      
      defense=self.defensive_energy()

      if(defense<received_attack)
        self.got_wounded()
        self.inc_consecutive_hits()

      else
        self.reset_hits()

      end

      if ((@@consecutive_hits==@@HITS2LOSE) || self.dead)

        self.reset_hits()
        lose = true 

      else
        lose = false

      end

      return lose
    end

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