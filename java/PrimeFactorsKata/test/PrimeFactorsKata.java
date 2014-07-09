import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//
//0 = []
//        1 = []
//        2 = [2]
//        3 = [3]
//        4 = 2, 2
// prime numbers
// remove prime numbers that dont divide exactly

public class PrimeFactorsKata {
    List<Integer> expectedResult;

    @Before
    public void setUp(){
        expectedResult = new ArrayList<Integer>();
    }

    @Test
    public void shouldGetPrimeFactorsForZero(){
        assertEquals(expectedResult, PrimeFactors.getPrimeFactors(0));
    }

    @Test
    public void shouldGetPrimeFactorsForOne(){
        assertEquals(expectedResult, PrimeFactors.getPrimeFactors(1));
    }

    @Test
    public void shouldGetPrimeFactorsForTwo(){
        expectedResult.add(2);
        assertEquals(expectedResult, PrimeFactors.getPrimeFactors(2));
    }

    @Test
    public void shouldGetPrimeFactorsForThree(){
        expectedResult.add(3);
        assertEquals(expectedResult, PrimeFactors.getPrimeFactors(3));
    }

    @Test
    public void shouldGetPrimeFactorsForFour(){
        expectedResult.add(2);
        expectedResult.add(2);
        assertEquals(expectedResult, PrimeFactors.getPrimeFactors(4));
    }

    @Test
    public void shouldGetPrimeFactorForFive(){
        expectedResult.add(5);
        assertEquals(expectedResult, PrimeFactors.getPrimeFactors(5));
    }
}
