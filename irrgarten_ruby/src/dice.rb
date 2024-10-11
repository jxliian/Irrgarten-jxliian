#encoding:utf-8


module Irrgarten

  class Dice

    @@MAX_USES = 5 #(número máximo de usos de armas y escudos)
    @@MAX_INTELLIGENCE = 10.0 #(valor máximo para la inteligencia de jugadores y monstruos)
    @@MAX_STRENGTH = 10.0 #(valor máximo para la fuerza de jugadores y monstruos)
    @@RESURRECT_PROB = 0.3 #(probabilidad de que un jugador sea resucitado en cada turno)
    @@WEAPONS_REWARD = 2 #(numero máximo de armas recibidas al ganar un combate)
    @@SHIELDS_REWARD = 3 #(numero máximo de escudos recibidos al ganar un combate)
    @@HEALTH_REWARD = 5 #(numero máximo de unidades de salud recibidas al ganar un combate)
    @@MAX_ATTACK = 3 #(máxima potencia de las armas)
    @@MAX_SHIELD = 2 #(máxima potencia de los escudos)
    
    @@generator= Random.new #(generador de números aleatorios)

    def self.random_pos(max)
      @@generator.rand(max.to_i)
    end

    def self.who_starts(nplayers)
      @@generator.rand(nplayers.to_i)
    end

    def self.random_intelligence()
      @@generator.rand(@@MAX_INTELLIGENCE.to_f)
    end

    def self.random_strength()
      @@generator.rand(@@MAX_STRENGTH.to_f)
    end

    def self.resurrect_player()
      @@generator.rand() < @@RESURRECT_PROB
    end

    def self.weapons_reward()
      @@generator.rand(@@WEAPONS_REWARD.to_i+1) ## revisar esto, por aqui me quedo
    end                                       ## no se si hay que ponerle +1
                                              ## a este, a los anteriores o los siguiente
    def self.shields_reward()
      @@generator.rand(@@SHIELDS_REWARD.to_i+1)
    end

    def self.health_reward()
      @@generator.rand(@@HEALTH_REWARD.to_i+1)
    end

    def self.weapon_power()
      @@generator.rand(@@MAX_ATTACK.to_f)
    end

    def self.shield_power()
      @@generator.rand(@@MAX_SHIELD.to_f)
    end

    def uses_left()
      @@generator.rand(@@MAX_USES.to_i+1)
    end      

    def self.intensity(competence)
      @@generator.rand(competence.to_f)
    end

    def discard_element(uses_left)
      probabilidad_inversa= (1-(uses_left.to_f/@@MAX_USES.to_f))
      
      if uses_left.to_i >= @@MAX_USES.to_i
        return false
      end

      if uses_left.to_i <= 0
        return true
      end
      
      return @@generator.rand() < probabilidad_inversa
    end
  
  end #end class

end #end module