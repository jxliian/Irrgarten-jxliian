#encoding:utf-8

module Irrgarten

## This is the main file that requires all the other files in the project
require_relative 'directions'
require_relative 'orientation'
require_relative 'game_character'
require_relative 'shield'
require_relative 'weapon'
require_relative 'dice'
require_relative 'game_state'

  class TestP1
      weapon = Weapon.new(3, 5)
      shield = Shield.new(5, 5)
      dados = Dice.new

      ## Probar el metodo de discard para el arma y el escudo
      weapon.discard
      shield.discard

      weapon.attack
      shield.protect

      puts "Weapon: #{weapon}"
      puts "Shield: #{shield}"
  
  end


end

