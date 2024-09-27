#encoding:utf-8

module main

class weapon

  @power #atributo de instancia de clase
  @uses #atributo de instancia de clase

  #constructor

  def initialize(power, uses)
    @power = power
    @uses = uses
  end

  def attack
    if uses >0
      @uses-=1
    return @power
    else 
      return 0
    end
  end

  def to_s
    return "W: #{@power} , #{@uses}"
  end
