import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void shouldSumNoNumbers(){
        StringCalculator stringCalculator = new StringCalculator();
        String inputString = "";
        int sum = stringCalculator.sum(inputString);

        assertEquals(0, sum);
    }

    @Test
    public void shouldSumOneNumber(){
        StringCalculator stringCalculator = new StringCalculator();
        String inputString = "1";
        int sum = stringCalculator.sum(inputString);

        assertEquals(1, sum);
    }

    @Test
    public void shouldSumMultipleNumbers(){
        StringCalculator stringCalculator = new StringCalculator();
        String inputString = "1, 4, 6, 10";
        int sum = stringCalculator.sum(inputString);

        assertEquals(21, sum);
    }
}
