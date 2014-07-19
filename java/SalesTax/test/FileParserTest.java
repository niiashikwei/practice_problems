import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileParserTest {
    @Test
    public void shouldReadOneLineOfInputToGetQuantityOfItem(){
        String inputLine = "1 book at 12.49";
        int expectedQuantity = 1;
        Item item = FileParser.parseLine(inputLine);
        int actualQuantity = item.getQuantity();
        assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void shouldReadOneLineOfInputToGetItemName(){
        String inputLine = "1 book at 12.49";
        String expectedName = "book";
        Item item = FileParser.parseLine(inputLine);
        String actualName = item.getName();
        assertEquals(expectedName, actualName);
    }
}
