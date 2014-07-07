import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class FizzBuzzTest {
    @Mock
    PrintStream mockPrintStream;

    @Before
    public void setUp(){
        initMocks(this);
    }

    @Test
    public void shouldPrintFizzIfThree(){
        int number = 3;
        Fizzbuzz.fizzBuzzInterpreter(number, mockPrintStream);
        verify(mockPrintStream).print("Fizz");
    }

    @Test
    public void shouldPrintFizzIfMultipleOfThree(){
        int multipleOfThree = 9;
        Fizzbuzz.fizzBuzzInterpreter(multipleOfThree, mockPrintStream);
        verify(mockPrintStream).print("Fizz");
    }

    @Test
    public void shouldPrintBuzzIfFive(){
        int number = 5;
        Fizzbuzz.fizzBuzzInterpreter(number, mockPrintStream);
        verify(mockPrintStream).print("Buzz");
    }

    @Test
    public void shouldPrintBuzzIfMultipleOfFive(){
        int multipleOfFive = 20;
        Fizzbuzz.fizzBuzzInterpreter(multipleOfFive, mockPrintStream);
        verify(mockPrintStream).print("Buzz");
    }

    @Test
    public void shouldPrintNumberIfNotThreeOrFive(){
        Integer number = 2;
        Fizzbuzz.fizzBuzzInterpreter(number, mockPrintStream);
        verify(mockPrintStream).print(number);
    }

    @Test
    public void shouldPrintFizzBuzzIfMultipleOfThreeAndFive(){
        int number = 15;
        Fizzbuzz.fizzBuzzInterpreter(number, mockPrintStream);
        verify(mockPrintStream).print("Fizz");
        verify(mockPrintStream).print("Buzz");
    }
}
