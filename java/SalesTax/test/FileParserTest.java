import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileParserTest {
    @Test
    public void shouldReadOneLineOfInputAndGetQuantityOfInputLine(){
        String inputString = "1 book at 12.49";
        int expectedQuantity = 1;
        InputLine inputLine = FileParser.parseLine(inputString);
        int actualQuantity = inputLine.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void shouldReadOneLineOfInputAndGetInputLineName(){
        String inputString = "1 book at 12.49";
        String expectedName = "book";
        InputLine inputLine = FileParser.parseLine(inputString);
        String actualName = inputLine.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldReadOneLineOfInputAndGetInputLinePrice(){
        String inputString = "1 book at 12.49";
        BigDecimal expectedPrice = new BigDecimal("12.49");
        InputLine inputLine = FileParser.parseLine(inputString);
        BigDecimal actualPrice = inputLine.getPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void shouldReadOneLineAndGetPriceIfItIsNotThirdInputLine(){
        String inputString = "1 music CD at 14.99";
        BigDecimal expectedPrice = new BigDecimal("14.99");
        InputLine inputLine = FileParser.parseLine(inputString);
        BigDecimal actualPrice = inputLine.getPrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void shouldReadOneLineOfInputAndNameIfItsTwoWordsLong(){
        String inputString = "1 music CD at 14.99";
        String expectedName = "music CD";
        InputLine inputLine = FileParser.parseLine(inputString);
        String actualName = inputLine.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldReadMultipleLinesAndCreateInputLines() throws IOException {
        InputLine inputLine1 = new InputLine(1, "book", new BigDecimal("12.49"));
        InputLine inputLine2 = new InputLine(1, "music CD", new BigDecimal("14.99"));
        List<InputLine> expectedInputLines = newArrayList(inputLine1, inputLine2);

        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        when(mockedBufferedReader.readLine()).thenReturn("1 book at 12.49", "1 music CD at 14.99", null);
        List<InputLine> actualInputLines = FileParser.parseInput(mockedBufferedReader);

        assertEquals(expectedInputLines, actualInputLines);
    }

}
