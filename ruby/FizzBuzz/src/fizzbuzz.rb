class Fizzbuzz
  def self.interpreter(number)
    return 'Fizz' if number % 3 == 0
    return 'Buzz' if number % 5 == 0
  end
end