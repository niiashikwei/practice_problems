require 'rspec'
require_relative '../src/fizzbuzz'

describe Fizzbuzz do
  it 'prints Fizz when passed 3' do
    Fizzbuzz.interpreter(3).should be_eql('Fizz')
  end

  it 'prints Fizz when iterating over a multiple of 3' do
    Fizzbuzz.interpreter(9).should be_eql('Fizz')
  end
end