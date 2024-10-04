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
      @@generator.rand(@@WEAPONS_REWARD.to_i) ## revisar esto, por aqui me quedo
    end



  end
end