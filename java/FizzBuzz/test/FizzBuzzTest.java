import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class FizzBuzzTest {
    @Mock
    PrintStream mockPrintStream;
    Fizzbuzz fizzbuzz;

    @Before
    public void setUp(){
        initMocks(this);
        fizzbuzz = new Fizzbuzz(mockPrintStream);
    }

    @Test
    public void shouldPrintFizzIfThree(){
        int number = 3;
        fizzbuzz.fizzBuzzInterpreter(number);
        verify(mockPrintStream).print("Fizz");
    }

    @Test
    public void shouldPrintFizzIfMultipleOfThree(){
        int multipleOfThree = 9;
        fizzbuzz.fizzBuzzInterpreter(multipleOfThree);
        verify(mockPrintStream).print("Fizz");
    }

    @Test
    public void shouldPrintBuzzIfFive(){
        int number = 5;
        fizzbuzz.fizzBuzzInterpreter(number);
        verify(mockPrintStream).print("Buzz");
    }

    @Test
    public void shouldPrintBuzzIfMultipleOfFive(){
        int multipleOfFive = 20;
        fizzbuzz.fizzBuzzInterpreter(multipleOfFive);
        verify(mockPrintStream).print("Buzz");
    }

    @Test
    public void shouldPrintNumberIfNotThreeOrFive(){
        Integer number = 2;
        fizzbuzz.fizzBuzzInterpreter(number);
        verify(mockPrintStream).print(number);
    }

    @Test
    public void shouldPrintFizzBuzzIfMultipleOfThreeAndFive(){
        int number = 15;
        fizzbuzz.fizzBuzzInterpreter(number);
        verify(mockPrintStream).print("Fizz");
        verify(mockPrintStream).print("Buzz");
    }
}
