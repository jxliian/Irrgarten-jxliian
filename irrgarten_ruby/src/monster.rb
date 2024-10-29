#encoding:utf-8

require_relative 'dice'

module Irrgarten

  # clase de los monstruos del juego
  class Monster

    # salud inicial de los monstruos

    @@INITIAL_HEALTH = 5.0

    def initialize(name, intelligence, strength)
      @name = name
      @intelligence = intelligence
      @strength = strength
      @health = @@INITIAL_HEALTH
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

    #def defend(@receivedAttack);
    # p3

    def set_pos(rows, column)
      @row = rows;
      @col = column;
    end

    def to_s()
      return "M [#{@name} #{@intelligence} #{@strength} #{@health} ]"
    end

    def got_wounded()
      @health -= 1
    end


  end # class
end # module