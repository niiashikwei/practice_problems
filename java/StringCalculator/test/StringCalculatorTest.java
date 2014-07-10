import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @Before
    public void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldSumNoNumbers(){
        String inputString = "";
        int sum = stringCalculator.sum(inputString);

        assertEquals(0, sum);
    }

    @Test
    public void shouldSumOneNumber(){
        String inputString = "1";
        int sum = stringCalculator.sum(inputString);

        assertEquals(1, sum);
    }

    @Test
    public void shouldSumMultipleNumbers(){
        String inputString = "1, 4, 6, 10";
        int sum = stringCalculator.sum(inputString);

        assertEquals(21, sum);
    }
}
