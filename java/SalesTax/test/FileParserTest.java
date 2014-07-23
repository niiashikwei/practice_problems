import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileParserTest {
    @Test
    public void shouldReadOneLineOfInputAndGetQuantityOfItem(){
        String inputLine = "1 book at 12.49";
        int expectedQuantity = 1;
        Item item = FileParser.parseLine(inputLine);
        int actualQuantity = item.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void shouldReadOneLineOfInputAndGetItemName(){
        String inputLine = "1 book at 12.49";
        String expectedName = "book";
        Item item = FileParser.parseLine(inputLine);
        String actualName = item.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldReadOneLineOfInputAndGetItemPrice(){
        String inputLine = "1 book at 12.49";
        double expectedPrice = 12.49;
        Item item = FileParser.parseLine(inputLine);
        double actualPrice = item.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void shouldReadOneLineAndGetPriceIfItIsNotThirdItem(){
        String inputLine = "1 music CD at 14.99";
        double expectedPrice = 14.99;
        Item item = FileParser.parseLine(inputLine);
        double actualPrice = item.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void shouldReadOneLineOfInputAndNameIfItsTwoWordsLong(){
        String inputLine = "1 music CD at 14.99";
        String expectedName = "music CD";
        Item item = FileParser.parseLine(inputLine);
        String actualName = item.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldReadMultipleLinesAndCreateItems() throws IOException {
        Item item1 = new Item(1, "book", 12.49);
        Item item2 = new Item(1, "music CD", 14.99);
        List<Item> expectedItems = newArrayList(item1, item2);

        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        when(mockedBufferedReader.readLine()).thenReturn("1 book at 12.49", "1 music CD at 14.99", null);
        List<Item> actualItems = FileParser.parseInput(mockedBufferedReader);

        assertEquals(expectedItems, actualItems);
    }

}
