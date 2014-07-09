import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

//
//0 = []
//        1 = []
//        2 = [2]
//        3 = [3]
//        4 = 2, 2
// prime numbers
// remove prime numbers that dont divide exactly

public class PrimeFactorsKata {
    @Test
    public void shouldGetPrimeFactorsForZero(){
        int[] expectedResult = new int[]{};
        assertArrayEquals(expectedResult, PrimeFactors.getPrimeFactors(0));
    }

    @Test
    public void shouldGetPrimeFactorsForOne(){
        int[] expectedResult = new int[]{};
        assertArrayEquals(expectedResult, PrimeFactors.getPrimeFactors(1));
    }

    @Test
    public void shouldGetPrimeFactorsForTwo(){
        int[] expectedResult = new int[]{2};
        assertArrayEquals(expectedResult, PrimeFactors.getPrimeFactors(2));
    }

    @Test
    public void shouldGetPrimeFactorsForThree(){
        int[] expectedResult = new int[]{3};
        assertArrayEquals(expectedResult, PrimeFactors.getPrimeFactors(3));
    }

    @Test
    public void shouldGetPrimeFactorsForFour(){
        int[] expectedResult = new int[]{2,2};
        assertArrayEquals(expectedResult, PrimeFactors.getPrimeFactors(4));
    }
}
