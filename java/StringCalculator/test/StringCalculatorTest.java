import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void shouldParseEmptyStringAndReturnEmptyArray(){
        StringCalculator stringCalculator = new StringCalculator();
        List<Integer> actualArray = stringCalculator.convertString("");
        List<Integer> expectedArray = newArrayList();

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldParseAStringThreeAndReturnIntegerThree(){
        StringCalculator stringCalculator = new StringCalculator();
        List<Integer> actualArray = stringCalculator.convertString("3");
        List<Integer> expectedArray = newArrayList(3);

        assertEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldParseStringWithTwoNumbersAndReturnArrayOfTwoIntegers(){
        StringCalculator stringCalculator = new StringCalculator();
        List<Integer> actualArray = stringCalculator.convertString("1, 2");
        List<Integer> expectedResult = newArrayList(1,2);

        assertEquals(expectedResult, actualArray);
    }

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
