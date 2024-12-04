#encoding:utf-8

require_relative 'dice'
require_relative 'combat_element'


module Irrgarten

  class Weapon < CombatElement

    def attack
      self.produce_effect
    end

    def to_s
      return "W:" + super
    end

  end
end