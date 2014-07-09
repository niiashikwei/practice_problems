import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


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
}
