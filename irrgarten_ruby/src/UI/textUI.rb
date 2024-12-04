
require 'io/console'
require_relative '../directions'

module UI

  class TextUI


    # @@output= Array.new

    # esto es lo que tengo que modificar para moverlo especificamente a donde yo quiera
    # de la forma que yo quiera.
    # def initialize
    #   @index=0
    #   @@output.push(Irrgarten::Directions::UP)
    #   @@output.push(Irrgarten::Directions::UP)

    #   20.times do
    #     @@output.push(Irrgarten::Directions::RIGHT)
    #   end
    # end

    #https://gist.github.com/acook/4190379
    def read_char
      STDIN.echo = false
      STDIN.raw!
    
      input = STDIN.getc.chr
      if input == "\e" 
        input << STDIN.read_nonblock(3) rescue nil
        input << STDIN.read_nonblock(2) rescue nil
      end
    ensure
      STDIN.echo = true
      STDIN.cooked!
    
      return input
    end

    def next_move
       print "Where? "
       got_input = false
       while (!got_input)
         c = read_char
         case c
           when "\e[A"
             puts "UP ARROW"
             output = Irrgarten::Directions::UP
             got_input = true
           when "\e[B"
             puts "DOWN ARROW"
             output = Irrgarten::Directions::DOWN
             got_input = true
           when "\e[C"
             puts "RIGHT ARROW"
             output = Irrgarten::Directions::RIGHT
             got_input = true
           when "\e[D"
             puts "LEFT ARROW"
             output = Irrgarten::Directions::LEFT
             got_input = true
           when "\u0003"
             puts "CONTROL-C"
             got_input = true
             exit(1)
           else
             #Error
         end
       end
       output

      #esto es asi no se cambia

      # out=@@output[@index]
      # @index+=1
      # return out
    end

    def show_game(game_state)
      
      puts game_state.labyrinth
      puts "\n"
      puts game_state.players
      puts "\n"
      puts game_state.monsters
      puts "\n"

      puts "Log:\n" + game_state.log + "\n"

      if (game_state.winner)
        puts "We have a winner! Player " + game_state.currentPlayer.to_s + "\n"
      else
        puts "Current player: " + game_state.currentPlayer.to_s + "\n"
      end
    end

  end # class   

end # module   


