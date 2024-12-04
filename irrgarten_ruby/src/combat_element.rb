#encoding:utf-8

require_relative 'dice'

# Abstract no se declara directamente aqui como en JAVA
module Irrgarten

  attr_accessor :effect, :uses

  class CombatElement

    def initialize(effect, uses)
      @uses= uses.to_i
      @effect= effect.to_f

    end

    protected 

    def produce_effect
      if @uses > 0
        @uses -= 1
        return @effect
      else
        return 0.0
      end
    end

    public 

    def discard
      return Dice.discard_element(@uses)
    end

    def to_s
      return "Effect: #{@effect}, Uses: #{@uses}"
    end

  end #class
end #module