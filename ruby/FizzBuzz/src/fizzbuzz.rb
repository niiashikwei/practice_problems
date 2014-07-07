class Fizzbuzz
  def self.interpreter(number)
    is_multiple_of_3 = number % 3 == 0
    is_multiple_of_5 = number % 5 == 0

    result = ''
    result = 'Fizz' if is_multiple_of_3
    result += 'Buzz' if is_multiple_of_5

    result.length > 0 ? result : number
  end

  def self.fizzbuzz
    (1..100).each { |number| puts interpreter(number) }
  end
end