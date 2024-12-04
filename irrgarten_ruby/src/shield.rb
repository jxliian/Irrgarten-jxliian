#encoding:utf-8

module Irrgarten

  require_relative 'dice'
  require_relative 'combat_element'

  class Shield < CombatElement

    def protect
      self.produce_effect
    end

    def to_s
      return "S:" + super

    end

  end #end class
end #end module