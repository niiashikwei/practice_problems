require 'rspec'
require_relative '../src/fizzbuzz'

describe Fizzbuzz do
  it 'prints Fizz when passed 3' do
    Fizzbuzz.interpreter(3).should be_eql('Fizz')
  end

  it 'prints Fizz when iterating over a multiple of 3' do
    Fizzbuzz.interpreter(9).should be_eql('Fizz')
  end

  it 'prints Buzz when interating over a multiple of 5' do
    Fizzbuzz.interpreter(20).should be_eql('Buzz')
  end

  it 'prints the number if it is not a multiple of 3 or 5' do
    Fizzbuzz.interpreter(17).should be_eql(17)
  end

  it 'prints the FizzBuzz if the number is a multiple of both 3 and 5' do
    Fizzbuzz.interpreter(15).should be_eql('FizzBuzz')
  end

  it 'print from 1 - 100 according to FizzBuzz requirements' do
    Fizzbuzz.should_receive(:interpreter).exactly(100).times
    Fizzbuzz.fizzbuzz
  end
end