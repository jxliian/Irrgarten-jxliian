#encoding:utf-8

require_relative 'dice'


module Irrgarten

  class Weapon

    # quiero que cada weapon tenga un poder y un numero de usos
    @power #atributo de instancia de clase
    @uses #atributo de instancia de clase

    #constructor

    def initialize(power, uses)
      @power = power.to_f
      @uses = uses.to_i
    end

    def attack
      if @uses >0
        @uses-=1
      return @power
      else 
        return 0
      end
    end

    def to_s
      return "W: #{@power} , #{@uses}"
    end

    def discard()
      dados = Dice.new
      dados.discard_element(@uses)
    end


  end
end