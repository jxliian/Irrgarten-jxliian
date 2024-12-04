#encoding:utf-8

# Abstract no se declara directamente aqui como en JAVA
module Irrgarten

  class LabyrinthCharacter

    @@INVALID_POS = -1

    def initialize(name, intelligence, strength, health)
      @name = name.to_s
      @intelligence = intelligence.to_f
      @strength = strength.to_f
      @health = health.to_f
      
      @row = @@INVALID_POS
      @col = @@INVALID_POS

    end  

    # consultores protected

    protected
    attr_reader :name, :intelligence, :strength
    attr_accessor :health

    public
    attr_reader :row, :col

    # metodos publicos
    
    def pos(row, col)
      @row = row  
      @col = col
    end

    def copy(other)
      @name = other.name
      @intelligence = other.intelligence
      @strength = other.strength
      @health = other.health
      pos(other.row, other.col)
    end
    
    def dead
      return @health <= 0
    end

    protected

    def got_wounded()
      @health -= 1
    end

    public

    def to_s

      return "#{@name} (#{@intelligence}, #{@strength}, #{@health}, #{@row}, #{@col})"

    end

    # ESTAS CLASES SE IMPLEMENTAN EN LAS CLASES HIJAS
    # asi se hace la herencia aqui xd??
    
    def attack
      raise NotImplementedError
    end

    def defend
      raise NotImplementedError
    end


  end #class
end #module