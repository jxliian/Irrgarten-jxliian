#encoding:utf-8

require_relative 'dice'
require_relative 'labyrinth'
require_relative 'game_state'

module Irrgarten

  class Game

    # numero maximo de rondas
    @@MAX_ROUNDS = 10

    # numero de filas y columnas del laberinto
    @@ROWS = 4
    @@COLS = 4

    @INIT_MONSTER=[["Monster 0", 0,0],
                  ["Monster 1", 0,3],
                  ["Monster 2", 3,0],
                  ["Monster 3", 3,3]]
    
    @@BLOCKS = [[Orientation::HORIZONTAL, 7, 7, 3],
                [Orientation::VERTICAL, 5, 5, 4],
                [Orientation::HORIZONTAL, 3, 3, 5],
                [Orientation::VERTICAL, 1, 1, 6]]

    def initialize(nplayers)
      @players= Array.new
      @monsters=Array.new

      nplayers.times do |i|
        @players.push(Player.new("Player "+i.to_s,
        Dice.random_intelligence()), Dice.random_strength())
      end

      @current_player_index=Dice.who_starts(nplayers)
      @current_player= @players[@current_player_index]

      @labyrinth= Labyrinth.new(@@ROWS, @@COLS, Dice.random_pos(@@ROWS), Dice.random_pos(@@COLS))
      configure_labirynth()
      @labyrinth.spread_players(@players)

      @log = "El juego acaba de comenzar"

    end

    #P3
    #def next_step(preferred_direction)

    def finished()
      return @labyrinth.have_a_winner
    end


    #genera una instancia con la info
    # del laberinto pero no se si esta ok
    def get_game_state()

      info_player= ""
      @players.each do |player|
        info_player+=player.to_s + "\n"
      end

      info_monster= ""
      @monsters.each do |monster|
        info_monster+=monster.to_s + "\n"
      end

      return game_state.new(@labyrinth.to_s, info_player, info_monster, @current_player.to_s, self.finished(), @log)

    end

    private

        def configure_labirynth

          @@BLOCKS.each do |block|
            orientation, row, col, length = block
            @labyrinth.add_block(orientation, row, col, length)
          end 

          @INIT_MONSTER.each do |monster_info|
            name, row, col = monster_info
            
            monster=(Monster.new(name, row, col, Dice.random_intelligence(), Dice.random_strength()))
            @monsters.push(monster)
            @labyrinth.add_monster(row, col, monster)
          
          end
        end

        # ??? esta bien mirar en p3...
        def next_player()

          @current_player_index=(@current_player_index+1) % @players.length
          @current_player= @players[@current_player_index]
        end 

        #p3
        #def actual_direction(preferred_direction)

        #p3
        #def combat(monster)

        #p3
        #def manage_reward(winner)

        #p3
        #def manage_resurrection()

        def log_player_won()
        @log+="Jugador #{@current_player_index}  ha ganado la partida"
        end
        
        def log_monster_won
          @log+="Monstruo ha ganado la pelea"

        end

        def log_resurrected
          @log+="Jugador #{@current_player_index} ha sido resucitado"
        end  

        def log_player_skip_turn
          @log+="Jugador #{@current_player_index} ha pasado su turno"
        end

        def log_player_no_orders
          @log+="Jugador #{@current_player_index} no ha seguido ninguna orden"
        end

        def log_no_monster
          @log+="Jugador #{@current_player_index} se ha movido a una casilla vacia o no es posible moverse ahi"
        end

        def log_rounds(rounds, max)
          @log+="Ronda #{rounds} de #{max}"
        end  

     
  end # class
end # module