class Fizzbuzz
  def self.interpreter(number)
    isMultipleOf3 = number % 3 == 0
    isMultipleOf5 = number % 5 == 0

    result = ''
    result = 'Fizz' if isMultipleOf3
    result += 'Buzz' if isMultipleOf5
    result = number unless result.length > 0

    return result
  end
end