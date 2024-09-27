#encoding:utf-8

module main

class shield

  @protection #atributo de instancia de clase
  @uses #atributo de instancia de clase

  #constructor

  def initialize(protection, uses)
    @protection = protection.to_f
    @uses = uses.to_i
  end

  def protect
    if uses >0
      @uses-=1
    return @protection
    else 
      return 0
    end
  end

  def to_s
    return "S: #{@protection} , #{@uses}"