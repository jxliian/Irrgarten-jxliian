#encoding:utf-8

module Irrgarten

## This is the main file that requires all the other files in the project
require_relative 'directions'
require_relative 'orientation'
require_relative 'game_character'
require_relative 'shield'
require_relative 'weapon'

  class Main

    weapon = Weapon.new(3, 5)
    shield = Shield.new(5, 5)

    weapon.attack
    shield.protect

    puts "Weapon: #{weapon}"
    puts "Shield: #{shield}"

  end
end