import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileParserTest {
    @Test
    public void shouldReadOneLineOfInputToGetQuantityOfItem(){
        String inputLine = "1 book at 12.49";
        int actualQuantity = FileParser.parseLine(inputLine);
        int expectedQuantity = 1;
        assertEquals(expectedQuantity, actualQuantity);
    }
}
