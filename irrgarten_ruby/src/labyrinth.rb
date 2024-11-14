#encoding:utf-8

require_relative 'directions'
require_relative 'dice'
require_relative 'orientation'

module Irrgarten

  class Labyrinth

    # Caracter para representar un bloque
    @@BLOCK_CHAR='X'
    # Caracter para representar un espacio vacio
    @@EMPTY_CHAR='-'
    # Caracter para representar un monstruo
    @@MONSTER_CHAR='M'
    # Caracter para representar un combate
    @@COMBAT_CHAR='C'
    # Caracter para representar una salida
    @@EXIT_CHAR='E'
    # Posicion invalida
    @@INVALID_POS=-1


    # Variables que representan filas y columnas
    @@ROW =0
    @@COL =1

    # Posicion invalida
    @@INVALID_POS= -1

    def initialize(nrows, ncols, exit_row, exit_col)
      @nrows=nrows.to_i
      @ncols=ncols.to_i
      @exit_row=exit_row.to_i
      @exit_col=exit_col.to_i

      # inicializamos el laberinto vacio
      # y se pone por defecto vacia, no hace falta bucle wow
      @labyrinth=Array.new(@nrows) {Array.new(@ncols, @@EMPTY_CHAR)}

      # definimos el resto de matrices
      @monsters=Array.new(@nrows) {Array.new(@ncols)}
      @players=Array.new(@nrows) {Array.new(@ncols)}

      # definimos la salida de la matriz del laberinto
      @labyrinth[@exit_row][@exit_col]=@@EXIT_CHAR

    end  

    #P3
    def spread_players(players)

      players.each do |p|
        pos=self.random_empty_pos()
        self.put_player_2D(@@INVALID_POS, @@INVALID_POS, pos[@@ROW], pos[@@COL], p)
      end


    end

    def have_a_winner()
      return @players[@exit_row][@exit_col] != nil
    end

    # esta no se si esta bien, lo hacen con 
    # un bucle for, pero no se si es necesario
    def to_s
      @labyrinth.map do |row|
        row.map { |cell| "[#{cell}]" }.join
      end.join("\n") + "\n"
    end

    def add_monster(row, col, monster)
      if pos_ok(row, col) && empty_pos(row, col)
        monster.set_pos(row, col)
        @monsters[row][col]=monster
        @labyrinth[row][col]=@@MONSTER_CHAR
      end
    end  

    # P3
    def put_player(direction, player)

      old_row=player.row
      old_col=player.col

      new_pos=self.dir_2_pos(old_row, old_col, direction)

      monster=self.put_player_2D(old_row, old_col, new_pos[@@ROW], new_pos[@@COL], player)

      return monster

    end


    # P3
    def add_block(orientation, start_row, start_col, length)

      if orientation==Orientation::HORIZONTAL
        inc_row=0
        inc_col=1
      else
        inc_row=1
        inc_col=0
      end

      row=start_row
      col=start_col

      while (pos_ok(row, col) && empty_pos(row,col) && length>0)
        @labyrinth[row][col]=@@BLOCK_CHAR
        row+=inc_row
        col+=inc_col
        length-=1
      end

    end


    # P3
    def valid_moves(row, col)

      output=Array.new

      if (self.can_step_on(row+1,col))
        output.push(Directions::DOWN)
      end
      if (self.can_step_on(row-1,col))
        output.push(Directions::UP)
      end
      if (self.can_step_on(row,col+1))
        output.push(Directions::RIGHT)
      end
      if (self.can_step_on(row,col-1))
        output.push(Directions::LEFT)
      end

      return output
    end

    private 
    def pos_ok(row, col)
      if row >=0 && row < @nrows && col >=0 && col < @ncols
        return true
      else
        return false
      end
    end

    def empty_pos(row, col)
      if @labyrinth[row][col]==@@EMPTY_CHAR
        return true
      else
        return false
      end
    end

    def monster_pos(row, col)
      if @labyrinth[row][col]==@@MONSTER_CHAR
        return true
      else
        return false
      end
    end

    def exit_pos(row, col)
      if @labyrinth[row][col]==@@EXIT_CHAR
        return true
      else
        return false
      end
    end

    def combat_pos(row, col)
      if @labyrinth[row][col]==@@COMBAT_CHAR
        return true
      else
        return false
      end
    end

    # funcion que me dice si puedo pasar o no
    def can_step_on(row, col)
      if pos_ok(row, col) && (empty_pos(row, col) || monster_pos(row, col) || exit_pos(row, col))
        return true
      else
        return false
      end
    end

    def update_old_pos(row, col)
      if (pos_ok(row, col))
        if (combat_pos(row, col))
          @labyrinth[row][col]=@@MONSTER_CHAR
        else
          @labyrinth[row][col]=@@EMPTY_CHAR
        end
      end  
    end

    def dir_2_pos(row, col, direction)

      # creo un array con posiciones
      nueva_pos=Array.new
      nueva_pos[@@ROW]=row
      nueva_pos[@@COL]=col

      #switch con los casos
      case direction
      when Directions::LEFT
        nueva_pos[@@COL]-=1
      when Directions::RIGHT
        nueva_pos[@@COL]+=1
      when Directions::UP
        nueva_pos[@@ROW]-=1
      when Directions::DOWN
        nueva_pos[@@ROW]+=1
      end
      return nueva_pos
    end

    def random_empty_pos()
    
      begin 
        row=Dice.random_pos(@nrows)
        col=Dice.random_pos(@ncols)

      end while !empty_pos(row, col)

      pos_a_devolver=Array.new
      pos_a_devolver[@@ROW]=row
      pos_a_devolver[@@COL]=col

      return pos_a_devolver
      
    end

    # P3
    def put_player_2D(old_row, old_col, row, col, player)

      output=nil

      if (self.can_step_on(row,col))
        if(self.pos_ok(old_row,old_col))
          p=@players[old_row][old_col]

          if (p==player)
            self.update_old_pos(old_row, old_col)
            @players[old_row][old_col]=nil
          end
        end

        monster_pos=self.monster_pos(row, col)

        if (monster_pos)
          @labyrinth[row][col]=@@COMBAT_CHAR
          output=@monsters[row][col]
        else
          @labyrinth[row][col]=player.number
        end

        @players[row][col]=player
        player.set_pos(row, col)
      end

      return output

    end

  end # class Labyrinth

end # module Irrgarten