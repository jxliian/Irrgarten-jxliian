#encoding:utf-8

module Irrgarten

  class Game_state 

    attr_accessor :labyrinth, :players, :monsters, :currentPlayer, :winner, :log

    def initialize(lab, player, monster, ctPlayer, winner_, log_)
      @labyrinth = lab
      @players = player
      @monsters = monster
      @currentPlayer = ctPlayer
      @winner = winner_
      @log = log_
    end

    def get_labyrinth
      return @labyrinth
    end

    def get_players
      return @players
    end

    def get_monsters
      return @monsters
    end

    def get_currentPlayer
      return @currentPlayer
    end

    def is_winner
      return @winner
    end

    def get_log
      return @log
    end

  end #end class
end #end module 