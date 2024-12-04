#encoding:utf-8

require_relative 'dice'
require_relative 'labyrinth_character'

module Irrgarten

  # clase de los monstruos del juego
  class Monster < LabyrinthCharacter

    # salud inicial de los monstruos

    @@INITIAL_HEALTH = 50000.0 # Solo por testeo de fuzzy
    @@INITIAL_STRENGTH = 10000   # Solo por testeo de fuzzy

    ## estos argumentos de row y col no deberia de ponerlos, estoy debugeando
    def initialize(name, intelligence, strength) # Solo por testeo de fuzzy
      super(name, intelligence, @@INITIAL_STRENGTH, @@INITIAL_HEALTH) # SOLO HABIRA QUE QUITAR EL INITIAL STRENGTH
    end                                                                # y pasarle el del parametro
    

    def attack()
      return Dice.intensity(@strength)
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
    
    def to_s()
      return "M" + super
    end


  end # class
end # module