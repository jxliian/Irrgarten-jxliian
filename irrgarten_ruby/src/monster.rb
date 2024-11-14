#encoding:utf-8

require_relative 'dice'

module Irrgarten

  # clase de los monstruos del juego
  class Monster

    # salud inicial de los monstruos

    @@INITIAL_HEALTH = 5.0

    ## estos argumentos de row y col no deberia de ponerlos, estoy debugeando
    def initialize(name, intelligence, strength, row, col)
      @name = name
      @intelligence = intelligence
      @strength = strength
      @health = @@INITIAL_HEALTH
      @row=row
      @col=col
    end

    def dead()
      @health <= 0
    end

    def get_strength()
      return @strength
    end

    def attack()
      return Dice.intensity(get_strength())
    end

    # p3
    def defend(received_attack)

      is_dead=dead

      if (!is_dead)

        defensive_energy=Dice.intensity(@intelligence)
        if (defensive_energy<received_attack)
          got_wounded
          is_dead=dead
        end
      end

      return is_dead
    end
    

    def set_pos(rows, column)
      @row = rows;
      @col = column;
    end

    def to_s()
      return "M [#{@name} #{@intelligence} #{@strength} #{@health} #{@row} #{@col}]"
    end

    def got_wounded()
      @health -= 1
    end


  end # class
end # module