import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void shouldPrintFizzIfThree(){
        int number = 3;
        assertEquals("Fizz", Fizzbuzz.fizzBuzzInterpreter(number));
    }

    @Test
    public void shouldPrintFizzIfMultipleOfThree(){
        int multipleOfThree = 9;
        assertEquals("Fizz", Fizzbuzz.fizzBuzzInterpreter(multipleOfThree));
    }

    @Test
    public void shouldPrintBuzzIfFive(){
        int number = 5;
        assertEquals("Buzz", Fizzbuzz.fizzBuzzInterpreter(number));
    }

    @Test
    public void shouldPrintBuzzIfMultipleOfFive(){
        int multipleOfFive = 20;
        assertEquals("Buzz", Fizzbuzz.fizzBuzzInterpreter(multipleOfFive));
    }

    @Test
    public void shouldPrintNumberIfNotThreeOrFive(){
        int number = 2;
        assertEquals("2", Fizzbuzz.fizzBuzzInterpreter(number));
    }

    @Test
    public void shouldPrintFizzBuzzIfMultipleOfThreeAndFive(){
        int number = 15;
        assertEquals("FizzBuzz", Fizzbuzz.fizzBuzzInterpreter(number));
    }
}
