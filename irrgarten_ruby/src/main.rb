#encoding:utf-8

## This is the main file that requires all the other files in the project
require_relative 'directions'
require_relative 'orientation'
require_relative 'game_character'
require_relative 'shield'
require_relative 'weapon'
require_relative 'dice'
require_relative 'game_state'


module Irrgarten

  class TestP1
      weapon = Weapon.new(3, 3)
      shield = Shield.new(5, 3)
      dados = Dice.new
      
      ## Probar el metodo de discard para el arma y el escudo
      puts "Weapon antes de atacar: #{weapon}"
      puts "Shield antes de proteger: #{shield}"
      puts "Se descarto el arma? #{weapon.discard}"
      puts "Se descarto el escudo? #{shield.discard}"

      weapon.attack
      shield.protect

      puts "Weapon despues de atacar: #{weapon}"
      puts "Shield despues de proteger: #{shield}"

      resultado=dados.discard_element(5)
      puts "Resultado de descartar 5 elementos: #{resultado}"
      resultado=dados.discard_element(3)
      puts "Resultado de descartar 3 elementos: #{resultado}"
      puts weapon.to_s; ## probando el metodo to_s
      puts shield.to_s; ## en ambos lados

      ## Crear instacias de weapon y probarlas

      weapon1 = Weapon.new(2, 5)
      weapon2 = Weapon.new(1, 0)
      puts "Weapon1 ataque: #{weapon1.attack}"
      puts "Weapon2 ataque: #{weapon2.attack}"

      ## Crear instancias de shield y probarlas

      shield1 = Shield.new(3, 2)
      shield2 = Shield.new(4, 0)
      puts "Shield1 proteccion: #{shield1.protect}"
      puts "Shield2 proteccion: #{shield2.protect}"

      ## Hacer lo de los 100 intentos en el dado de dice

      total_descartes=0;
      for i in 1..100
        uses_left = dados.uses_left
        discard = dados.discard_element(uses_left)
        if (discard)
          total_descartes += 1
        end
        puts "Descartar elemento: #{i} con #{uses_left} usos restantes: #{discard}"
      
      end ## end for

      puts "Total de descartes en 100 intentos, siendo true que descarto: #{total_descartes}"

## ----------------------------- Probar los diferentes enumerados pero en ruby --------------------------------------------------------##

      direccion=Directions::UP
      puts "Direccion: #{direccion}"

      orientacion=Orientation::VERTICAL
      puts "Orientacion: #{orientacion}"

      jugador=Game_character::PLAYER
      puts "Jugador: #{jugador}"

## ----------------------------------- Probar las instancias de GameState -----------------------------------------------------------##

      ##def initialize(lab, player, monster, ctPlayer, winner_, log_)
      estado= Game_state.new("Laberinto", "Jugadores", "Monstruos", 0, false, "Log")
      puts "Estado, no tengo to_s pero deberia ser algo asi xp: #{estado}"

  end ## end class
end #end module

